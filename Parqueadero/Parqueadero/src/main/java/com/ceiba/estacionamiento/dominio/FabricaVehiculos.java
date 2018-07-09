package com.ceiba.estacionamiento.dominio;

public class FabricaVehiculos {
	
	
	public Vehiculo crearVehiculo(String cilindraje, String placa, String tipo) {
		Vehiculo vehiculo = null;
		if("carro".equals(tipo)) {
			vehiculo = new Carro(placa);
		}else {
			vehiculo = new Moto(placa, Short.parseShort(cilindraje));
		}
		
		return vehiculo;
	}

}
