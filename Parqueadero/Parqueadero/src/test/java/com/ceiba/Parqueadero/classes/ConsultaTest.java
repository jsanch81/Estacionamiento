package com.ceiba.Parqueadero.classes;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.Parqueadero.classes.Consulta;
import com.ceiba.Parqueadero.classes.Tiempo;
import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.model.VehiculoModel;
import com.ceiba.Parqueadero.model.Vehiculos;



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
		Vehiculos resultado = consulta.genConsulta(placa, tiempo);
		//Assert
		Assert.assertNull(resultado);
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

		Vehiculos resultado = consulta.genConsulta(placa, tiempo);
		//Assert
		Assert.assertNotNull(resultado);
	}
	
	@Test
	public void ListVehiculos() {
		//Arrange
		List<Vehiculos> listVehiculos = new ArrayList<Vehiculos>();
		//Act
		Mockito.when(vehiculoCRUD.vehiculosIntoParking(Mockito.any(Tiempo.class))).thenReturn(listVehiculos);
		List<Vehiculos> result = consulta.consultarVehiculosEnElParqueadero(tiempo);
		//Assert
		Assert.assertEquals(listVehiculos, result);
	}
}
