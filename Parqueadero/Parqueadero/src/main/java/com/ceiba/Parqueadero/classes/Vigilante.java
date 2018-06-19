package com.ceiba.Parqueadero.classes;

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
}
