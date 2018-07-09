package com.ceiba.estacionamiento.dominio;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.estacionamiento.dominio.Tiempo;
import com.ceiba.estacionamiento.modelos.TiempoParqueado;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;



	

public class TiempoTest {

	private Tiempo tiempo = new Tiempo();
	
	
	@Test
	public void ejemploDayHourMils() {
		//Arrange
		TiempoParqueado salida = new TiempoParqueado(6,7,5*60000);
		Calendar calendar = Calendar.getInstance();
		long value1 = calendar.getTimeInMillis();
		calendar.add(Calendar.DAY_OF_YEAR, 5);
		calendar.add(Calendar.HOUR, 30);
		calendar.add(Calendar.MINUTE, 65);
		long value2 = calendar.getTimeInMillis();
		
		//Act
		TiempoParqueado resultado=tiempo.calculateDaysHoursMils(value1, value2);
		
		//Assert
		Assert.assertThat(salida, samePropertyValuesAs(resultado));
	}
	
	@Test
	public void dateToStringTest() {
		//Arrange
		@SuppressWarnings("deprecation")
		Date date = new Date(118,5,28,4,22,10);
		
		//Act
		String result = tiempo.dateToString(date);
		
		//Assert
		
		Assert.assertEquals("28/06/2018 04:22:10",result);
	}
}