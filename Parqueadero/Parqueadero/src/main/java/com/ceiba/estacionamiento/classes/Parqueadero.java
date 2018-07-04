package com.ceiba.estacionamiento.classes;

public class Parqueadero {
	private short maxMotorbike;
	private short maxCars;
	private short totalCars;
	private short totalMotorbikes;
	
	/**
	 * initialize the attributes of the parking
	 */
	public Parqueadero() {
		this.maxCars = 20;
		this.maxMotorbike = 10;
		this.totalCars = 0;
		this.totalMotorbikes = 0;
	}
	
	public Parqueadero(short totalCars, short totalMotorbikes) {
		this.maxCars = 20;
		this.maxMotorbike = 10;
		this.totalCars = totalCars;
		this.totalMotorbikes = totalMotorbikes;
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
	
	/**
	 * 
	 * @return total cars in the parking
	 */
	public short getTotalCars() {
		return this.totalCars;
	}
	
	/**
	 * 
	 * @return total Motorbikes in the parking
	 */
	public short getTotalMotorbikes() {
		return this.totalMotorbikes;
	}
	
	/**
	 * 
	 * @param totalMotorbikes: length of motorbikes in the parking.
	 * this method validate that the total of motorbikes do not overcome the max 
	 * of motorbikes in the parking
	 */
	public void setTotalMotorbikes(short totalMotorbikes) {
		this.totalMotorbikes =  totalMotorbikes;
	}
	
	/**
	 * 
	 * @param totalCars: length of cars in the parking.
 	 * this method validate that the total of cars do not overcome the max 
	 * of cars in the parking
	 */	
	public void setTotalCars(short totalCars) {
		this.totalCars = totalCars;
	}
	
	/**
	 * 
	 * @return true if there are quota to cars
	 */
	public boolean hayCupoCarro() {
		return this.totalCars<this.maxCars;
	}
	
	/**
	 * 
	 * @return true if there are quota to motorbikes
	 */
	public boolean hayCupoMoto() {
		return this.totalMotorbikes<this.maxMotorbike;
	}
}
