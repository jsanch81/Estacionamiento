package com.ceiba.estacionamiento.dominio;

public class Parqueadero {
	private short maxMotorbike;
	private short maxCars;
	
	/**
	 * initialize the attributes of the parking
	 */
	public Parqueadero() {
		this.maxCars = 20;
		this.maxMotorbike = 10;

	}
	
	/**
	 * 
	 * @return  return the limit of motorbikes that the parking can receive
	 */
	public short getMaxMotorbike() {
		return this.maxMotorbike;
	}
	
	/**
	 * 
	 * @return return the limit of cars that the parking can receive
	 */
	public short getMaxCars() {
		return this.maxCars;
	}
	
	
	
	public boolean hayCupoVehiulo(short [] vehiculosDentroDelParqueadero, String tipo) {
		if("moto".equals(tipo)) {
			return vehiculosDentroDelParqueadero[0]<this.maxMotorbike;
		}else {
			return vehiculosDentroDelParqueadero[1]<this.maxCars;
		}
	}
}
