package com.ceiba.estacionamiento.classes;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.estacionamiento.classes.CobroSalidaParqueadero;
import com.ceiba.estacionamiento.classes.Parqueadero;
import com.ceiba.estacionamiento.classes.SalidaParqueadero;
import com.ceiba.estacionamiento.classes.Tiempo;

public class CobrarTest {

	@Mock
	private SalidaParqueadero salida;

	@Mock
	private Tiempo tiempo;

	@InjectMocks
	private CobroSalidaParqueadero cobrar;

	@Mock
	private Parqueadero parqueadero;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void generarCobroTestCarro() {
		

		// Arrage
		String placa = "EHG44B";
		// cobrar.setSalida(salida);
		int[] dayHoursMils = new int[3];
		dayHoursMils[0] = 1;
		dayHoursMils[1] = 3;
		dayHoursMils[2] = 0;
		Calendar calendar = Calendar.getInstance();

		// Act
		Mockito.when(salida.generarSalida(placa, parqueadero)).thenReturn(calendar.getTimeInMillis());
		Mockito.when(salida.tipoVehiculo(placa)).thenReturn("carro");
		Mockito.when(salida.getCilindraje(placa)).thenReturn((short) 0);
		Mockito.when(tiempo.calculateDaysHoursMils(Mockito.anyLong(), Mockito.anyLong())).thenReturn(dayHoursMils);
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		int valor = cobrar.generarCobro(placa, tiempo, parqueadero);

		int esperado = 11000;
		// Assert
		Assert.assertEquals(esperado, valor);

	}
	
	@Test
	public void generarCobroTestCarro2() {
		

		// Arrage
		String placa = "EHG44B";
		// cobrar.setSalida(salida);
		int[] dayHoursMils = new int[3];
		dayHoursMils[0] = 5;
		dayHoursMils[1] = 8;
		dayHoursMils[2] = 1200;
		Calendar calendar = Calendar.getInstance();

		// Act
		Mockito.when(salida.generarSalida(placa, parqueadero)).thenReturn(calendar.getTimeInMillis());
		Mockito.when(salida.tipoVehiculo(placa)).thenReturn("carro");
		Mockito.when(salida.getCilindraje(placa)).thenReturn((short) 0);
		Mockito.when(tiempo.calculateDaysHoursMils(Mockito.anyLong(), Mockito.anyLong())).thenReturn(dayHoursMils);
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		int valor = cobrar.generarCobro(placa, tiempo, parqueadero);

		int esperado = dayHoursMils[0] * 8000;
		esperado += (dayHoursMils[1] < 9) ? dayHoursMils[1] * 1000 : 8000;
		esperado += (dayHoursMils[2] > 0) ? 1000 : 0;

		// Assert
		Assert.assertEquals(esperado, valor);

	}

	@Test
	public void generarCobroTestMoto() {

		// Arrage
		String placa = "EHG44B";
		int[] dayHoursMils = new int[3];
		dayHoursMils[0] = 0;
		dayHoursMils[1] = 10;
		dayHoursMils[2] = 0;
		Calendar calendar = Calendar.getInstance();
		short cilindraje = 650;
		
		// Act
		Mockito.when(salida.generarSalida(placa, parqueadero)).thenReturn(calendar.getTimeInMillis());
		Mockito.when(salida.tipoVehiculo(placa)).thenReturn("moto");
		Mockito.when(salida.getCilindraje(placa)).thenReturn(cilindraje);
		Mockito.when(tiempo.calculateDaysHoursMils(Mockito.anyLong(), Mockito.anyLong())).thenReturn(dayHoursMils);
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());

		int valor = cobrar.generarCobro(placa, tiempo, parqueadero);
		int esperado = dayHoursMils[0] * 4000;
		esperado += (dayHoursMils[1] < 9) ? dayHoursMils[1] * 500 : 4000;
		esperado += (dayHoursMils[2] > 0) ? 500 : 0;
		esperado += (cilindraje > 500) ? 2000 : 0;
		// Assert

		Assert.assertEquals(esperado, valor);

	}

	@Test
	public void generarCobroTestMoto2() {

		// Arrage
		String placa = "EHG44B";
		int[] dayHoursMils = new int[3];
		dayHoursMils[0] = 20;
		dayHoursMils[1] = 10;
		dayHoursMils[2] = 5;
		Calendar calendar = Calendar.getInstance();
		short cilindraje = 250;
		// Act
		Mockito.when(salida.generarSalida(placa, parqueadero)).thenReturn(calendar.getTimeInMillis());
		Mockito.when(salida.tipoVehiculo(placa)).thenReturn("moto");
		Mockito.when(salida.getCilindraje(placa)).thenReturn(cilindraje);
		Mockito.when(tiempo.calculateDaysHoursMils(Mockito.anyLong(), Mockito.anyLong())).thenReturn(dayHoursMils);
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());

		int valor = cobrar.generarCobro(placa, tiempo, parqueadero);
		int esperado = dayHoursMils[0] * 4000;
		esperado += (dayHoursMils[1] < 9) ? dayHoursMils[1] * 500 : 4000;
		esperado += (dayHoursMils[2] > 0) ? 500 : 0;
		esperado += (cilindraje > 500) ? 2000 : 0;
		// Assert

		Assert.assertEquals(esperado, valor);

	}
}
