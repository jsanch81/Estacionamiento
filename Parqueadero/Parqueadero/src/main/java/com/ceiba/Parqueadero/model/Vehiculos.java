package com.ceiba.Parqueadero.model;


public class Vehiculos {
	private String placa;
	private String fechaIngreso;
	private String tipo;
	
	
	public Vehiculos(String placa, String fechaIngreso, String tipo) {
		super();
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.tipo = tipo;
	}
	
	public Vehiculos() {}
	
	
	public String getPlaca() {
		return placa;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
