package com.ceiba.estacionamiento.dominio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ceiba.estacionamiento.modelos.TiempoParqueado;

public class Tiempo {

	private Calendar date;
	
	public Tiempo() {
		date = Calendar.getInstance();
	}
	
	public Tiempo(Calendar date) {
		this.date = date;
	}
	
	public int getDiaSemana() {
		return date.get(Calendar.DAY_OF_WEEK);
	}
	
	public Date getDate() {
		return date.getTime();
	}
	
	public long getTimestamp() {
		return date.getTimeInMillis();
	}
	
	public TiempoParqueado calcularDiasHorasMils(long ingreso, long salida) {
		long diferencia = salida-ingreso;
		int dias = (int)(diferencia/86400000);
		int horas = (int) ((diferencia%86400000)/3600000);
		int milis = (int) ((diferencia%86400000)%3600000);
		
		return new TiempoParqueado(dias,horas,milis);
	}
	
	
	public String dateToString(Date date) {
		DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return df2.format(date);
	}
	
}
