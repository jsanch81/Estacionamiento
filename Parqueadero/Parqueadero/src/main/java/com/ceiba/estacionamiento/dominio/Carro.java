package com.ceiba.estacionamiento.dominio;

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
