package com.ceiba.Parqueadero.classes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.model.VehiculoModel;

import java.util.Calendar;

import org.junit.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SalidaTest {

	@Autowired
	private Salida salida;
	
	@Mock
	private VehiculoCRUD vehiculoCRUD;
	
	@Mock
	private VehiculoModel vehiculoModel;
	
	@Mock
	private Parqueadero parqueadero;
	
	
	@Test
	public void genSalidaCarroTest() {
		
		//Arrange
		String placa = "HKG137";
		Calendar calendar = Calendar.getInstance();
		salida.setVehiculoCRUD(vehiculoCRUD);
		
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("carro");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.genSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(calendar.getTimeInMillis(), resultado);
		
	}
	
	@Test
	public void genSalidaMotoTest() {
		
		//Arrange
		String placa = "EHG44B";
		salida.setVehiculoCRUD(vehiculoCRUD);
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.genSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(calendar.getTimeInMillis(), resultado);
		
	}
	
	@Test
	public void genSalidaNotCarroTest() {
		
		//Arrange
		String placa = "HKG127";
		salida.setVehiculoCRUD(vehiculoCRUD);
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.genSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(-1, resultado);
		
	}
	
	@Test
	public void genSalidaNotCarroTest2() {
		
		//Arrange
		String placa = "EHG44D";
		salida.setVehiculoCRUD(vehiculoCRUD);
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.genSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(-1, resultado);
		//Assert.assertEquals((int)-1, resultado);
		
	}
	
	@Test
	public void genSalidaNotUpdateCarroTest2() {
		
		//Arrange
		String placa = "EHG44E";
		salida.setVehiculoCRUD(vehiculoCRUD);
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.findVehiculo(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		Mockito.when(vehiculoModel.getIngresoTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short)5);
		long resultado = salida.genSalida(placa, parqueadero);
		
		//Assert
		Assert.assertEquals(-2, resultado);
		
	}
}
