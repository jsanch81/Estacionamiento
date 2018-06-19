package com.ceiba.Parqueadero.classes;

import java.util.Map;

public class Vigilante {
	private String name;
	private String cc;
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
	public void registrar(Parqueadero parqueadero, Map<String , String> map) {
        Vehiculo vehiculo;
        Registro registro;
		if(map.get("cilindraje").equals("")) {
        	System.out.println("Carro");
        	vehiculo = new Carro(map.get("placa"));
        	registro = new Registro(parqueadero);
        	registro.registrar(true, vehiculo);
        }else {
        	System.out.println("Moto");
        	short value = Short.parseShort(map.get("cilindraje"));
        	vehiculo = new Moto(map.get("placa"),value);
        	registro = new Registro(parqueadero);
        	registro.registrar(false, vehiculo);
        }
		
	}
}
