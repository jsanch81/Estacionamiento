package com.ceiba.Parqueadero.classes;



import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.model.VehiculoModel;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsultaTest {

	@Autowired
	private Consulta consulta;
	
	@Mock
	private VehiculoModel vehiculoModel;
	
	@Mock
	private VehiculoCRUD vehiculoCRUD;
	
	@Mock
	private Tiempo tiempo;
	
	@Test
	public void genConsultaTestError() {
		//Arrange
		String placa = "ASD123";
		consulta.setVehiculoCRUD(vehiculoCRUD);
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
		consulta.setVehiculoCRUD(vehiculoCRUD);
		consulta.setTiempo(tiempo);
		consulta.setVehiculoModel(vehiculoModel);
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
