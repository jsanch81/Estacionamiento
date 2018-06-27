package com.ceiba.Parqueadero.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.Parqueadero.crud.VehiculoCRUD;

@Service
public class SalidaParqueadero {

	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	private final String CARRO = "carro";
	
	public long generarSalida(String placa, Parqueadero parqueadero) {
		
		if(parqueadero.getTotalCars()==0 ) parqueadero.setTotalCars(vehiculoCRUD.numCarsInParking()[1]);
		
		if(parqueadero.getTotalMotorbikes()==0) parqueadero.setTotalMotorbikes(vehiculoCRUD.numCarsInParking()[0]);

		if(!vehiculoCRUD.findIntoParking(placa)) return -1;
				
		if(vehiculoCRUD.findIntoParking(placa)&&!vehiculoCRUD.validateVehiculo(placa)) return -1;
		
		if(!vehiculoCRUD.updateSalidaVehiculo(placa)) return -2;
		System.out.println(vehiculoCRUD.findVehiculo(placa).getTipo());
		if(vehiculoCRUD.findVehiculo(placa).getTipo().equals(CARRO)) {
			parqueadero.setTotalCars((short) (parqueadero.getTotalCars()-1));
			System.out.println("Total de carros: "+parqueadero.getTotalCars());

		}else {
			parqueadero.setTotalMotorbikes((short) (parqueadero.getTotalMotorbikes()-1));
			System.out.println("Total de motos: "+parqueadero.getTotalMotorbikes());
		}
		
		return vehiculoCRUD.findVehiculo(placa).getIngresoTimestamp();
	}
	
	public String tipoVehiculo(String placa) {
		return vehiculoCRUD.findVehiculo(placa).getTipo();
	}
	
	public short getCilindraje(String placa) {
		return vehiculoCRUD.findVehiculo(placa).getCilindraje();
	}

}
