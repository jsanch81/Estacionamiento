package com.ceiba.estacionamiento.classes;

public class Moto extends Vehiculo{
	private short cilndraje;
	private String tipoVehiculo =  "moto";
	
	public Moto(String placa, short cilindraje) {
		super(placa);
		this.cilndraje = cilindraje;
	}
	
	public short getCilindraje() {
		return this.cilndraje;
	}

	@Override
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
}
