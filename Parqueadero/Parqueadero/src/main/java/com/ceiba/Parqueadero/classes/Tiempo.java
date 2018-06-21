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
	
	
}
