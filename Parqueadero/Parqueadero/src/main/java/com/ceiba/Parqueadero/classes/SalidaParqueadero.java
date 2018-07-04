package com.ceiba.parqueadero.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.crud.VehiculoCRUD;

@Service
public class SalidaParqueadero {

	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	private static final String CARRO = "carro";
	
	/**
	 * 
	 * @param placa
	 * @param parqueadero
	 * @return
	 */
	public long generarSalida(String placa, Parqueadero parqueadero) {
		
		if(parqueadero.getTotalCars()==0 ) parqueadero.setTotalCars(vehiculoCRUD.numCarsInParking()[1]);
		
		if(parqueadero.getTotalMotorbikes()==0) parqueadero.setTotalMotorbikes(vehiculoCRUD.numCarsInParking()[0]);

		if(!vehiculoCRUD.findIntoParking(placa)) return -1;
				
		if(vehiculoCRUD.findIntoParking(placa)&&!vehiculoCRUD.validateVehiculo(placa)) return -1;
		
		if(!vehiculoCRUD.updateSalidaVehiculo(placa)) return -2;
		if(vehiculoCRUD.findVehiculo(placa).getTipo().equals(CARRO)) {
			parqueadero.setTotalCars((short) (parqueadero.getTotalCars()-1));

		}else {
			parqueadero.setTotalMotorbikes((short) (parqueadero.getTotalMotorbikes()-1));
		}
		
		return vehiculoCRUD.findVehiculo(placa).getIngresoTimestamp();
	}
	
	/**
	 * 
	 * @param placa
	 * @return
	 */
	public String tipoVehiculo(String placa) {
		return vehiculoCRUD.findVehiculo(placa).getTipo();
	}
	/**
	 * 
	 * @param placa
	 * @return
	 */
	public short getCilindraje(String placa) {
		return vehiculoCRUD.findVehiculo(placa).getCilindraje();
	}

}
