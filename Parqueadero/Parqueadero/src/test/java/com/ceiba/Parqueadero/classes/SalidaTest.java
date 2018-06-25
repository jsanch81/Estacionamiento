package com.ceiba.Parqueadero.classes;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.model.VehiculoModel;

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
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("carro");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.generarSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(calendar.getTimeInMillis(), resultado);
		
	}
	
	@Test
	public void generarSalidaMotoTest() {
		
		//Arrange
		String placa = "EHG44B";
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.generarSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(calendar.getTimeInMillis(), resultado);
		
	}
	
	@Test
	public void generarSalidaNotCarroTest() {
		
		//Arrange
		String placa = "HKG127";
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.generarSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(-1, resultado);
		
	}
	
	@Test
	public void generarSalidaNotCarroTest2() {
		
		//Arrange
		String placa = "EHG44D";
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.generarSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(-1, resultado);
		//Assert.assertEquals((int)-1, resultado);
		
	}
	
	@Test
	public void generarSalidaNotUpdateCarroTest2() {
		
		//Arrange
		String placa = "EHG44E";
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.generarSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(-2, resultado);
		
	}
}
