package com.ceiba.estacionamiento.dominio;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.estacionamiento.dominio.CobroSalidaParqueadero;
import com.ceiba.estacionamiento.dominio.SalidaParqueadero;
import com.ceiba.estacionamiento.dominio.Tiempo;

public class CobrarTest {

	@Mock
	private SalidaParqueadero salida;

	@Mock
	private Tiempo tiempo;

	@InjectMocks
	private CobroSalidaParqueadero cobrar;
	
	@Mock
	private CostoTotal costoTotal;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void generarCobroTestCarro() {
		

		// Arrage
		String placa = "EHG44B";

		Calendar calendar = Calendar.getInstance();

		// Act
		Mockito.when(salida.generarSalida(Mockito.anyString())).thenReturn(calendar.getTimeInMillis());
		Mockito.when(salida.tipoVehiculo(Mockito.anyString())).thenReturn("carro");
		Mockito.when(salida.getCilindraje(Mockito.anyString())).thenReturn((short) 0);
		Mockito.when(costoTotal.generarCosto(Mockito.anyString(), Mockito.anyLong(), Mockito.anyLong(), Mockito.any(Tiempo.class), Mockito.anyShort())).thenReturn(11000);
		int valor = cobrar.generarCobro(placa, tiempo);

		int esperado = 11000;
		// Assert
		Assert.assertEquals(esperado, valor);

	}
	

}


