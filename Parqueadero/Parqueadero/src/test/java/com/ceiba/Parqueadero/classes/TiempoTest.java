package com.ceiba.Parqueadero.classes;

import com.ceiba.Parqueadero.classes.Tiempo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TiempoTest {
	
	private Tiempo tiempo;
	private Tiempo tiempo2;
	@Before
	public void setup() {
		tiempo = new Tiempo();
		tiempo2 = Mockito.mock(Tiempo.class);
	}
	
	@Test
	public void testTiempo() {
		//Arrage
		String placa = "EHG44B";
		Mockito.when(tiempo2.getDayWeek()).thenReturn(4);
		//Act
		boolean salida = tiempo.canPark(placa);
		//Assert
		Assert.assertEquals(false, salida);
		
	}
	
}
