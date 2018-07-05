package com.ceiba.estacionamiento.classes;

public class Carro extends Vehiculo{
	
	private String tipoVehiculo =  "carro";
	
	public Carro(String placa) {
		super(placa);
	}

	@Override
	public short getCilindraje() {
		return 0;
	}

	@Override
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
}
