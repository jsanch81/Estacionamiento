package com.ceiba.Parqueadero.classes;



import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.model.VehiculoModel;



public class ConsultaTest {

	@InjectMocks
	private Consulta consulta;
	
	@Mock
	private VehiculoModel vehiculoModel;
	
	@Mock
	private VehiculoCRUD vehiculoCRUD;
	
	@Mock
	private Tiempo tiempo;
	

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void genConsultaTestError() {
		//Arrange
		String placa = "ASD123";
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(false);
		String resultado = consulta.genConsulta(placa);
		//Assert
		Assert.assertEquals("El vihiculo no esta en la base de datos", resultado);
	}
	
	@Test
	public void genConsultaTest() {
		//Arrange
		String placa = "ASD123";
		Date date = new Date();
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findVehiculo(placa)).thenReturn(vehiculoModel);
		Mockito.when(tiempo.dateToString(Mockito.any(Date.class))).thenReturn("25-06-2018 08:03:27");
		Mockito.when(vehiculoModel.getFechaIngreso()).thenReturn(date);
		Mockito.when(vehiculoModel.getPlaca()).thenReturn(placa);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");

		String resultado = consulta.genConsulta(placa);
		//Assert
		Assert.assertEquals(" Placa: "+placa +"\n Tipo Vehiculo: moto" +"\n Fecha ingreso: 25-06-2018 08:03:27", resultado);
	}
	
}
