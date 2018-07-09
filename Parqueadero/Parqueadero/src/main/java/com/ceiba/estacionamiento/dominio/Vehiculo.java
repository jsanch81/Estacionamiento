package com.ceiba.estacionamiento.dominio;

public abstract class Vehiculo {

	private String placa;
		
	public Vehiculo(String placa) {
		this.placa = placa;
	}
	
	public String getPlaca() {
		return this.placa;
	}

	public abstract short getCilindraje();
	
	public abstract String getTipoVehiculo();
	
}
