package com.ceiba.estacionamiento.dominio;

public class Parqueadero {
	private short cupoMaximoMotos;
	private short cupoMaximoCarros;
	
	/**
	 * initialize the attributes of the parking
	 */
	public Parqueadero() {
		this.cupoMaximoCarros = 20;
		this.cupoMaximoMotos = 10;

	}
	
	/**
	 * 
	 * @return  return the limit of motorbikes that the parking can receive
	 */
	public short getMaximoMotos() {
		return this.cupoMaximoMotos;
	}
	
	/**
	 * 
	 * @return return the limit of cars that the parking can receive
	 */
	public short getMaximoCarros() {
		return this.cupoMaximoCarros;
	}
	
	
	/**
	 * this method validate if there are spaces in the parking to motorbikes of cars.
	 * @param vehiculosDentroDelParqueadero
	 * @param tipo
	 * @return
	 */
	public boolean hayCupoVehiulo(short [] vehiculosDentroDelParqueadero, String tipo) {
		if("moto".equals(tipo)) {
			return vehiculosDentroDelParqueadero[0]<this.cupoMaximoMotos;
		}else {
			return vehiculosDentroDelParqueadero[1]<this.cupoMaximoCarros;
		}
	}
}
