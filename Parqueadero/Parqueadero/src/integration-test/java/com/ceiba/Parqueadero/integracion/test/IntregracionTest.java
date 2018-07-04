package com.ceiba.parqueadero.integracion.test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.classes.Consulta;
import com.ceiba.parqueadero.classes.Parqueadero;
import com.ceiba.parqueadero.classes.Tiempo;
import com.ceiba.parqueadero.classes.Vigilante;
import com.ceiba.parqueadero.model.Vehiculos;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class IntregracionTest {
	
	@Autowired
	private Vigilante vigilante;
	
	@Autowired
	private Consulta consulta;
	private Parqueadero parqueadero = new Parqueadero();
	
	private Tiempo tiempo;
	
	private Calendar date = Calendar.getInstance();
	
	 
	@Test
	public void cobrar() {
		
		//Arrange
		String placa = "MMM445";
		tiempo = new Tiempo(date);
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		
		//Act
		vigilante.registrar(parqueadero, map, tiempo);		
		date.add(Calendar.DAY_OF_YEAR, 1);
		tiempo = new Tiempo(date);
		int resultado2 = vigilante.cobrar(parqueadero, map, tiempo);
		//Assert
		Assert.assertEquals(4000, resultado2);
	}
	
	@Test
	public void registrar() {
		//Arrange
		String placa = "MMM446";
		tiempo = new Tiempo(date);
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		
		//Act
		String resultado = vigilante.registrar(parqueadero, map, tiempo);		
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);

		
	}
	
	@Test
	public void consultar() {
		//Arrange
		String placa = "MMM447";
		tiempo = new Tiempo();
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		
		//Act
		vigilante.registrar(parqueadero, map, tiempo);	
		Vehiculos vehiculo = consulta.genConsulta(placa, tiempo);
		
		//Assert
		Assert.assertNotNull(vehiculo);
	}
	
}
