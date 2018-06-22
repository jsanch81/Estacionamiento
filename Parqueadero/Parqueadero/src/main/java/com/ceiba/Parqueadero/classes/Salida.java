package com.ceiba.Parqueadero.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.ceiba.Parqueadero.crud.VehiculoCRUD;

@Service
@Configurable
public class Salida {

	@Autowired
	private VehiculoCRUD vehiculoCRUD;

	
	public long genSalida(String placa, Parqueadero parqueadero) {
		
		if(!vehiculoCRUD.findIntoParking(placa)) return -1;
				
		if(vehiculoCRUD.findIntoParking(placa)&&!vehiculoCRUD.validateVehiculo(placa)) return -1;
		
		if(!vehiculoCRUD.updateSalidaVehiculo(placa)) return -2;
		
		if(vehiculoCRUD.findVehiculo(placa).getTipo().equals("carro")) {
			parqueadero.setTotalCars((short) (parqueadero.getTotalCars()-1));
		}else {
			parqueadero.setTotalCars((short) (parqueadero.getTotalMotorbikes()-1));
		}
		
		
		return vehiculoCRUD.findVehiculo(placa).getIngresoTimestamp();
	}
	
	public String tipoVehiculo(String placa) {
		return vehiculoCRUD.findVehiculo(placa).getTipo();
	}
	
	public short getCilindraje(String placa) {
		return vehiculoCRUD.findVehiculo(placa).getCilindraje();
	}
	
	public void setVehiculoCRUD(VehiculoCRUD vehiculoCRUD) {
		this.vehiculoCRUD = vehiculoCRUD;
	}

}
