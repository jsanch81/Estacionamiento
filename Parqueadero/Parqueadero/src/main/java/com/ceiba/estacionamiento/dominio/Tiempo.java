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
	
	/**
	 * it gets a number of day at week of now
	 * @return
	 */
	public int getDiaSemana() {
		return date.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * It gets the date of now
	 * @return
	 */
	public Date getDate() {
		return date.getTime();
	}
	
	/**
	 * It gets the timestamp of now
	 * @return
	 */
	public long getTimestamp() {
		return date.getTimeInMillis();
	}
	
	/**
	 * This method calculate the numbers of days, hours and millisecond with the difference 
	 * between two timestams (date got in, date got out)  
	 * @param ingreso
	 * @param salida
	 * @return
	 */
	public TiempoParqueado calcularDiasHorasMils(long ingreso, long salida) {
		long diferencia = salida-ingreso;
		int dias = (int)(diferencia/86400000);
		int horas = (int) ((diferencia%86400000)/3600000);
		int milis = (int) ((diferencia%86400000)%3600000);
		
		return new TiempoParqueado(dias,horas,milis);
	}
	
	/**
	 * This method change a date to a string with the format "dd/MM/yyyy HH:mm:ss"
	 * @param date
	 * @return
	 */
	public String dateToString(Date date) {
		DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return df2.format(date);
	}
	
}
