package com.ceiba.Parqueadero.classes;

import java.util.Calendar;

import org.junit.Test;



public class TiempoTest {

	private Tiempo tiempo = new Tiempo();
	
	@Test
	public void ejemploDayHourMils() {
		Calendar calendar = Calendar.getInstance();
		long value1 = calendar.getTimeInMillis();
		calendar.add(Calendar.DAY_OF_YEAR, 5);
		calendar.add(Calendar.HOUR, 30);
		calendar.add(Calendar.MINUTE, 65);
		long value2 = calendar.getTimeInMillis();
		int[] salida=tiempo.calculateDaysHoursMils(value1, value2);
		System.out.println("Dias: "+salida[0]+"   horas: "+salida[1]+"    milis: "+salida[2]);
	}
}