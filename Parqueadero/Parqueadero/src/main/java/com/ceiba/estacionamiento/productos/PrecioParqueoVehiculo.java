package com.ceiba.estacionamiento.productos;

public abstract class PrecioParqueoVehiculo {
	
	private int costoDia;
	private int costoHora;
	private int costoExtra;
	
	public PrecioParqueoVehiculo(){}

	public int getCostoDia() {
		return costoDia;
	}

	public int getCostoHora() {
		return costoHora;
	}

	public int getCostoExtra() {
		return costoExtra;
	}

	public void setCostoDia(int costoDia) {
		this.costoDia = costoDia;
	}

	public void setCostoHora(int costoHora) {
		this.costoHora = costoHora;
	}

	public void setCostoExtra(int costoExtra) {
		this.costoExtra = costoExtra;
	}
	
}
