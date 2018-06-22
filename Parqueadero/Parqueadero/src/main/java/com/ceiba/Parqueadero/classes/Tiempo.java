package com.ceiba.Parqueadero.classes;

import java.util.Calendar;
import java.util.Date;

public class Tiempo {

	private Calendar date;
	
	public Tiempo() {
		date = Calendar.getInstance();
	}
	
	public int getDayWeek() {
		return date.get(Calendar.DAY_OF_WEEK);
	}
	
	public Date getDate() {
		return date.getTime();
	}
	
	public long getTimestamp() {
		return date.getTimeInMillis();
	}
	
	public int[] calculateDaysHoursMils(long ingreso, long salida) {
		int[] dayHoursMils = new int[3];
		long diferencia = salida-ingreso;
		dayHoursMils[0] = (int)(diferencia/86400000);
		dayHoursMils[1]= (int) ((diferencia%86400000)/3600000);
		dayHoursMils[2]= (int) ((diferencia%86400000)%3600000);
		System.out.println("Dias: "+dayHoursMils[0]+" horas: "+dayHoursMils[1]+" mils: "+dayHoursMils[2]);
		return dayHoursMils;
	}
	
}
