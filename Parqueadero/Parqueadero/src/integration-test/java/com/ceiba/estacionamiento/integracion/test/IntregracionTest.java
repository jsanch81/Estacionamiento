package com.ceiba.estacionamiento.integracion.test;

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

import com.ceiba.estacionamiento.dominio.Consulta;
import com.ceiba.estacionamiento.dominio.Parqueadero;
import com.ceiba.estacionamiento.dominio.Tiempo;
import com.ceiba.estacionamiento.dominio.Vigilante;
import com.ceiba.estacionamiento.modelos.Vehiculos;


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
		String tipo = "moto";
		String cilindraje = "125";
		tiempo = new Tiempo(date);

		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);

		
		//Act
		vigilante.realizarRegistro(parqueadero, map, tiempo);		
		date.add(Calendar.DAY_OF_YEAR, 1);
		tiempo = new Tiempo(date);
		int resultado2 = vigilante.realizarCobro(map, tiempo);
		//Assert
		Assert.assertEquals(4000, resultado2);
	}
	
	@Test
	public void registrarMoto() {
		//Arrange
		String placa = "MMM446";
		String cilindraje = "125";
		String tipo = "moto";
		tiempo = new Tiempo(date);
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);
		
		//Act
		String resultado = vigilante.realizarRegistro(parqueadero, map, tiempo);		
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);

	}
	@Test
	public void registrarCarro() {
		//Arrange
		String placa = "MMM455";
		String cilindraje = "125";
		String tipo = "carro";
		tiempo = new Tiempo(date);
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);
		
		
		//Act
		String resultado = vigilante.realizarRegistro(parqueadero, map, tiempo);		
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);

		
	}
	
	@Test
	public void consultar() {
		//Arrange
		String placa = "MMM447";
		String cilindraje = "125";
		String tipo = "carro";
		tiempo = new Tiempo();

		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);

		//Act
		vigilante.realizarRegistro(parqueadero, map, tiempo);	
		Vehiculos vehiculo = consulta.generarConsulta(placa, tiempo);
		
		//Assert
		Assert.assertNotNull(vehiculo);
	}
	
}
