package com.ceiba.Parqueadero.classes;

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
	
	public short getMaxMotorbike() {
		return this.maxMotorbike;
	}
	
	public short getMaxCars() {
		return this.maxCars;
	}
	
	public short getTotalCars() {
		return this.totalCars;
	}
	
	public short getTotalMotorbikes() {
		return this.totalMotorbikes;
	}
	
	/**
	 * 
	 * @param totalMotorbikes: length of motorbikes in the parking.
	 * this method validate that the total of motorbikes don´t overcome the max 
	 * of motorbikes in the parking
	 */
	public void setTotalMotorbikes(short totalMotorbikes) {
		this.totalMotorbikes = (this.totalMotorbikes<this.maxMotorbike) ? totalMotorbikes : this.totalMotorbikes;
	}
	
	/**
	 * 
	 * @param totalCars: length of cars in the parking.
 	 * this method validate that the total of cars don´t overcome the max 
	 * of cars in the parking
	 */	
	public void setTotalCars(short totalCars) {
		this.totalCars = (this.totalCars<this.maxCars) ? totalCars : this.totalCars;
	}
}
