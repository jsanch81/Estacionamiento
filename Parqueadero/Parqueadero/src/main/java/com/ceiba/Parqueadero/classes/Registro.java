package com.ceiba.Parqueadero.classes;

import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.classes.Moto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class Registro {
	
	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	private static final String NO_HAY_CUPO = "No hay cupo";
	private static final String CARRO = "carro";
	private static final String MOTO = "moto";
	private static final String REGISTRO_REALIZADO = "Registro realizado";
	private static final String ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS = "Error al guardar en la base de datos";
	private static final String EL_VEHICULO_YA_INGRESO = "El vehiculo ya ingreso";
	
	/**
	 * 
	 * @param tipoVehiculo
	 * @param vehiculo
	 * @return
	 */
	public String registrar(Parqueadero parqueadero, boolean tipoVehiculo, Vehiculo vehiculo) {
		String placa = vehiculo.getPlaca();
		if(vehiculoCRUD.findIntoParking(placa)&&vehiculoCRUD.validateVehiculo(placa)) return EL_VEHICULO_YA_INGRESO;
		
		if(tipoVehiculo) {
			
			if(!parqueadero.hayCupoCarro()) return NO_HAY_CUPO;
			short cilindrajeCarro = 0;
			
			if(vehiculoCRUD.findIntoParking(placa)&&!vehiculoCRUD.validateVehiculo(placa)) {
				if(!vehiculoCRUD.updateVehiculo(placa)) return ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS;
			}else if(!vehiculoCRUD.save(placa, CARRO, cilindrajeCarro)) return ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS;

			parqueadero.setTotalCars((short)(parqueadero.getTotalCars()+1));
			System.out.println("Total Carros en el parqueadero: "+parqueadero.getTotalCars());

			return REGISTRO_REALIZADO;
			
		} else {
			if(!parqueadero.hayCupoMoto()) return NO_HAY_CUPO;
			
			Moto moto = (Moto)vehiculo;
			
			if(vehiculoCRUD.findIntoParking(placa)&&!vehiculoCRUD.validateVehiculo(placa)) {
				if(!vehiculoCRUD.updateVehiculo(placa)) return ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS;
			}else if(!vehiculoCRUD.save(placa, MOTO,  moto.getCilindraje())) return ERROR_AL_GUARDAR_EN_LA_BASE_DE_DATOS;
			
			parqueadero.setTotalMotorbikes((short)(parqueadero.getTotalMotorbikes()+1));
			System.out.println("Total Motos en el parqueadero: "+parqueadero.getTotalMotorbikes());
			
			return REGISTRO_REALIZADO;
		}
	}
	
	public void setVehiculoCRUD(VehiculoCRUD vehiculoCRUD) {
		this.vehiculoCRUD = vehiculoCRUD;
	}
	 
	
}
