package com.ceiba.Parqueadero.classes;

public class Registro {
	private Parqueadero parqueadero;
	
	public static String NO_HAY_CUPO = "No hay cupo";
	public static String REGISTRO_REALIZADO = "Registro realizado";
	
	public Registro(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}
	
	/**
	 * 
	 * @param tipoVehiculo
	 * @param vehiculo
	 */
	public String registrar(boolean tipoVehiculo, Vehiculo vehiculo) {
		if(tipoVehiculo) {
			if(!parqueadero.hayCupoCarro()) return NO_HAY_CUPO;
			parqueadero.setTotalCars((short)(parqueadero.getTotalCars()+1));
			System.out.println("Total Carros en el parqueadero: "+parqueadero.getTotalCars());
			return REGISTRO_REALIZADO;
			
		} else {
			if(!parqueadero.hayCupoMoto()) return NO_HAY_CUPO;
			parqueadero.setTotalMotorbikes((short)(parqueadero.getTotalMotorbikes()+1));
			System.out.println("Total Motos en el parqueadero: "+parqueadero.getTotalMotorbikes());
			return REGISTRO_REALIZADO;
		}
	}
	 
	
}
