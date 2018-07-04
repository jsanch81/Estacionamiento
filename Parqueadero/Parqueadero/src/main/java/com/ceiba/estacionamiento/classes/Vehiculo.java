package com.ceiba.estacionamiento.classes;

public class Vehiculo {

	private String placa;
	
	public Vehiculo(String placa) {
		this.placa = placa;
	}
	
	public String getPlaca() {
		return this.placa;
	}

	public boolean findIntoParking() {
		return false;
	}
	
}
