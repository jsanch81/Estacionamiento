package com.ceiba.estacionamiento.modelos;

public class TiempoParqueado {
	private int dias;
	private int horas;
	private int milis;
	
	
	public int getDias() {
		return dias;
	}
	
	
	public TiempoParqueado(int dias, int horas, int milis) {
		super();
		this.dias = dias;
		this.horas = horas;
		this.milis = milis;
	}

	public int getHoras() {
		return horas;
	}
	public int getMilis() {
		return milis;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public void setMilis(int milis) {
		this.milis = milis;
	}
	
}
