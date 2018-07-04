package com.ceiba.Parqueadero.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.Parqueadero.classes.Moto;
import com.ceiba.Parqueadero.crud.VehiculoCRUD;

@Service
public class Registro {
	
	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	private static final String NO_HAY_CUPO = "No hay cupo";
	private static final String CARRO = "carro";
	private static final String MOTO = "moto";
	private static final String REGISTRO_REALIZADO = "Registro realizado";
	private static final String ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS = "Error al guardar en la base de datos";
	private static final String EL_VEHICULO_YA_INGRESO = "El vehiculo ya ingreso";
	private static final String ESTE_VEHICULO_YA_SE_REGISTRO_COMO_MOTO = "Este vehiculo ya se registro como una moto";
	private static final String ESTE_VEHICULO_YA_SE_REGISTRO_COMO_CARRO = "Este vehiculo ya se registro como un carro";
	/**
	 * 
	 * @param tipoVehiculo
	 * @param vehiculo
	 * @return
	 */
	public String registrarCarro(Parqueadero parqueadero, Carro carro, Tiempo tiempo) {
		String placa = carro.getPlaca();
		if(parqueadero.getTotalCars()==0 ) parqueadero.setTotalCars(vehiculoCRUD.numCarsInParking()[1]);

		if(vehiculoCRUD.findIntoParking(placa)&&vehiculoCRUD.validateVehiculo(placa)) return EL_VEHICULO_YA_INGRESO;
		
			if(!parqueadero.hayCupoCarro()) return NO_HAY_CUPO;
			short cilindrajeCarro = 0;
			
			if(vehiculoCRUD.findIntoParking(placa)&&!vehiculoCRUD.validateVehiculo(placa)) {
				if(vehiculoCRUD.findVehiculo(placa).getTipo().equals(MOTO)) return ESTE_VEHICULO_YA_SE_REGISTRO_COMO_MOTO;
				if(!vehiculoCRUD.updateVehiculo(placa, tiempo)) return ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS;
			}else if(!vehiculoCRUD.save(placa, CARRO, cilindrajeCarro, tiempo)) return ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS;

			parqueadero.setTotalCars((short)(parqueadero.getTotalCars()+1));

			return REGISTRO_REALIZADO;
			
	
	}
	
	
	public String registrarMoto(Parqueadero parqueadero, Moto moto, Tiempo tiempo) {
		String placa = moto.getPlaca();
		
		if(parqueadero.getTotalMotorbikes()==0) parqueadero.setTotalMotorbikes(vehiculoCRUD.numCarsInParking()[0]);

		if(vehiculoCRUD.findIntoParking(placa)&&vehiculoCRUD.validateVehiculo(placa)) return EL_VEHICULO_YA_INGRESO;
		
		
		if(!parqueadero.hayCupoMoto()) return NO_HAY_CUPO;
		
	
		
		if(vehiculoCRUD.findIntoParking(placa)&&!vehiculoCRUD.validateVehiculo(placa)) {
			if(vehiculoCRUD.findVehiculo(placa).getTipo().equals(CARRO)) return ESTE_VEHICULO_YA_SE_REGISTRO_COMO_CARRO;
			if(!vehiculoCRUD.updateVehiculo(placa, tiempo)) return ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS;
		}else if(!vehiculoCRUD.save(placa, MOTO,  moto.getCilindraje(), tiempo)) return ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS;
		
		parqueadero.setTotalMotorbikes((short)(parqueadero.getTotalMotorbikes()+1));

		return REGISTRO_REALIZADO;
	}
	
	
	 
	
}
