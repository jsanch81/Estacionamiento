package com.ceiba.testdatabuilder;

import com.ceiba.Parqueadero.classes.Carro;
import com.ceiba.Parqueadero.classes.Moto;
import com.ceiba.Parqueadero.classes.Vehiculo;

public class VehiculoTestDataBuilder {
	private String placa;
	private short cilindraje;
	
	public VehiculoTestDataBuilder() {
		this.placa = "EHG44B";
		this.cilindraje = 125;
	}
	

	public VehiculoTestDataBuilder withcilindraje(short cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Vehiculo buildCarro(){
		return new Carro(this.placa);
	}
	
	public Vehiculo buildMoto() {
		return new Moto(this.placa, this.cilindraje);
	}
}
