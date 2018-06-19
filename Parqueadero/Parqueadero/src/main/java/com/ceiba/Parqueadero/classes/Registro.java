package com.ceiba.Parqueadero.classes;

import java.util.Calendar;

public class Registro {
	private Calendar dateEntry;
	private Parqueadero parqueadero;
	
	public Registro(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
		this.dateEntry = Calendar.getInstance();
	}
	
	
	public void registrar(boolean tipoVehiculo, Vehiculo vehiculo) {
		if(tipoVehiculo) {
			parqueadero.setTotalCars((short)(parqueadero.getTotalCars()+1));
		} else {
			parqueadero.setTotalMotorbikes((short)(parqueadero.getTotalMotorbikes()+1));
		}
		System.out.println("Total Carros en el parqueadero: "+parqueadero.getTotalCars());
		System.out.println("Total Motos en el parqueadero: "+parqueadero.getTotalMotorbikes());
		System.out.println(dateEntry);
	}
	 
	
}
