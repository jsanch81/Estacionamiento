package com.ceiba.parqueadero.classes;

public class Moto extends Vehiculo{
	private short cilndraje;
	
	public Moto(String placa, short cilindraje) {
		super(placa);
		this.cilndraje = cilindraje;
	}
	
	public short getCilindraje() {
		return this.cilndraje;
	}
}
