package com.ceiba.Parqueadero.integracion.test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.Parqueadero.classes.Parqueadero;
import com.ceiba.Parqueadero.classes.Tiempo;
import com.ceiba.Parqueadero.classes.Vigilante;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntregracionTest {
	
	@Autowired
	private Vigilante vigilante;
	
	private Parqueadero parqueadero = new Parqueadero();
	
	private Tiempo tiempo;
	
	private Calendar date = Calendar.getInstance();
	
	private String placa = "MMM445";
	@Test
	public void registrar() {
		
		//Arrange
		tiempo = new Tiempo(date);
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		
		//Act
		System.out.println(tiempo.getDate());

		String resultado = vigilante.registrar(parqueadero, map, tiempo);		
		date.add(Calendar.DAY_OF_YEAR, 1);
		
		tiempo = new Tiempo(date);
		System.out.println(parqueadero.getTotalMotorbikes());
		System.out.println(tiempo.getDate()+"  "+date.getTime());

		int resultado2 = vigilante.cobrar(parqueadero, map, tiempo);
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
		Assert.assertEquals(8000, resultado2);
	}
	
	@Test
	public void cobrar() {
		
		//Arrange

		
		//Act
		
		
		//Assert

		
	}
	
}
