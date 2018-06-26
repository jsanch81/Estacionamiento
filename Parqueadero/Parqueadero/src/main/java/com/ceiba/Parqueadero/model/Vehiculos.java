package com.ceiba.Parqueadero.model;

import java.util.Date;

public class Vehiculos {
	private String placa;
	private Date fechaIngreso;
	private String tipo;
	
	
	public Vehiculos(String placa, Date fechaIngreso, String tipo) {
		super();
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.tipo = tipo;
	}
	
	public Vehiculos() {}
	
	
	public String getPlaca() {
		return placa;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
