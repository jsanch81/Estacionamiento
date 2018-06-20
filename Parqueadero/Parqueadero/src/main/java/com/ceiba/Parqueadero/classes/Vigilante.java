package com.ceiba.Parqueadero.classes;

import java.util.Map;

public class Vigilante {
	private String name;
	private String cc;
	public static String NO_PUEDE_INGRESAR_HOY = "No puede ingresar hoy";
	public Vigilante(String name, String cc) {
		this.name = name;
		this.cc = cc;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCC() {
		return this.cc;
	}
	/**
	 * 
	 * @param parqueadero
	 * @param map
	 */
	public String registrar(Parqueadero parqueadero, Map<String , String> map) {
        Vehiculo vehiculo;
        Registro registro;
        Tiempo tiempo = new Tiempo();
        String placa = map.get("placa");
        String cilindraje = map.get("cilindraje");
        
        if(tiempo.canPark(placa)) return NO_PUEDE_INGRESAR_HOY;
		
        if(cilindraje.equals("")) {
        	vehiculo = new Carro(placa);
        	registro = new Registro(parqueadero);
        	return registro.registrar(true, vehiculo);
        }else {
        	short value = Short.parseShort(cilindraje);
        	vehiculo = new Moto(placa,value);
        	registro = new Registro(parqueadero);
        	return registro.registrar(false, vehiculo);
        }
		
	}
}
