package com.ceiba.estacionamiento.dominio;



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

import com.ceiba.estacionamiento.crud.VehiculoCRUD;
import com.ceiba.estacionamiento.dominio.Consulta;
import com.ceiba.estacionamiento.dominio.Tiempo;
import com.ceiba.estacionamiento.modelos.VehiculoModel;
import com.ceiba.estacionamiento.modelos.Vehiculos;



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
		Mockito.when(vehiculoCRUD.vehiculoRegistrado(Mockito.anyString())).thenReturn(false);
		Vehiculos resultado = consulta.generarConsulta(placa, tiempo);
		//Assert
		Assert.assertNull(resultado);
	}
	
	@Test
	public void genConsultaTest() {
		//Arrange
		String placa = "ASD123";
		Date date = new Date();
		
		//Act
		Mockito.when(vehiculoCRUD.vehiculoRegistrado(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.buscarVehiculo(placa)).thenReturn(vehiculoModel);
		Mockito.when(tiempo.dateToString(Mockito.any(Date.class))).thenReturn("25-06-2018 08:03:27");
		Mockito.when(vehiculoModel.getFechaIngreso()).thenReturn(date);
		Mockito.when(vehiculoModel.getPlaca()).thenReturn(placa);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");

		Vehiculos resultado = consulta.generarConsulta(placa, tiempo);
		//Assert
		Assert.assertNotNull(resultado);
	}
	
	@Test
	public void ListVehiculos() {
		//Arrange
		List<Vehiculos> listVehiculos = new ArrayList<Vehiculos>();
		//Act
		Mockito.when(vehiculoCRUD.vehiculosParqueados(Mockito.any(Tiempo.class))).thenReturn(listVehiculos);
		List<Vehiculos> result = consulta.consultarVehiculosParqueados(tiempo);
		//Assert
		Assert.assertEquals(listVehiculos, result);
	}
}
