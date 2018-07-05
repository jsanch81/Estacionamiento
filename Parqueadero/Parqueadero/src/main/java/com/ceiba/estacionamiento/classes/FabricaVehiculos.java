package com.ceiba.estacionamiento.classes;

public class FabricaVehiculos {
	
	
	public Vehiculo crearVehiculo(String cilindraje, String placa) {
		Vehiculo vehiculo = null;
		if( cilindraje == null || cilindraje.equals("") ) {
			vehiculo = new Carro(placa);
		}else {
			vehiculo = new Moto(placa, Short.parseShort(cilindraje));
		}
		
		return vehiculo;
	}

}
