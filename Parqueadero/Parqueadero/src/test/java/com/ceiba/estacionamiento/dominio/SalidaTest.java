package com.ceiba.estacionamiento.dominio;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.estacionamiento.crud.VehiculoCRUD;
import com.ceiba.estacionamiento.dominio.Parqueadero;
import com.ceiba.estacionamiento.dominio.SalidaParqueadero;
import com.ceiba.estacionamiento.modelos.VehiculoModel;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;



public class SalidaTest {
	
	@InjectMocks
	private SalidaParqueadero salida;
	
	@Mock
	private VehiculoCRUD vehiculoCRUD;
	
	@Mock
	private VehiculoModel vehiculoModel;
	
	@Mock
	private Parqueadero parqueadero;
	
	@Mock
	private Validaciones validaciones;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void generarSalidaCarroTest() {
		
		//Arrange
		String placa = "HKG137";
		Calendar calendar = Calendar.getInstance();
		
		
		//Act
		Mockito.when(validaciones.validarSalidaVehiculo(placa)).thenReturn((long) 0);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());

		long resultado = salida.generarSalida(placa);
		
		//Assert
		Assert.assertEquals(calendar.getTimeInMillis(), resultado);
		
	}
	
	@Test
	public void generarSalidaMotoTest() {
		
		//Arrange
		String placa = "EHG44B";
		Calendar calendar = Calendar.getInstance();
		
		//Act
		//Act
		Mockito.when(validaciones.validarSalidaVehiculo(placa)).thenReturn((long) 0);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());

		long resultado = salida.generarSalida(placa);
		
		//Assert
		Assert.assertEquals(calendar.getTimeInMillis(), resultado);
		
	}
	
	@Test
	public void generarSalidaNotCarroTest() {
		
		//Arrange
		String placa = "HKG127";
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(validaciones.validarSalidaVehiculo(placa)).thenReturn((long) -1);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());

		long resultado = salida.generarSalida(placa);
		//Assert
		Assert.assertEquals(-1, resultado);
		
	}
	
	@Test
	public void generarSalidaNotCarroTest2() {
		
		//Arrange
		String placa = "EHG44D";
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(validaciones.validarSalidaVehiculo(placa)).thenReturn((long) -1);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());

		long resultado = salida.generarSalida(placa);
		
		//Assert
		Assert.assertEquals(-1, resultado);
		
	}
	
	@Test
	public void generarSalidaNotUpdateCarroTest2() {
		
		//Arrange
		String placa = "EHG44E";
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(validaciones.validarSalidaVehiculo(placa)).thenReturn((long) -2);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());

		long resultado = salida.generarSalida(placa);
		
		//Assert
		Assert.assertEquals(-2, resultado);
		
	}
	
	@Test
	public void tipoVehiculoTest() {
		//Arrange
		String placa = "EHG44B";
		
		//Act
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		String resultado = salida.tipoVehiculo(placa);
		
		//Assert
		Assert.assertEquals("moto", resultado);
	}
	@Test
	public void getCilindrajeTest() {
		//Arrange
		String placa = "EHG44B";
		
		//Act
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getCilindraje()).thenReturn((short) 125);
		short resultado = salida.getCilindraje(placa);
		
		//Assert
		Assert.assertEquals(125, resultado);
	}
}
