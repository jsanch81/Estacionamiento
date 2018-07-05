package com.ceiba.estacionamiento.classes;

import org.junit.Assert;
import org.junit.Test;


public class ParqueaderoTest {
	//Arrange
	private Parqueadero parqueadero = new Parqueadero();
	
	@Test
	public void getMaxMotorbikeTest() {
		//Arrange
		short valorEsperado = 10;
		//Act
		short resultado = parqueadero.getMaxMotorbike();
		//Assert
		Assert.assertEquals(valorEsperado, resultado);
	}
	
	@Test
	public void getMaxCarsTest() {
		//Arrange
		short valorEsperado = 20;
		//Act
		short resultado = parqueadero.getMaxCars();
		//Assert
		Assert.assertEquals(valorEsperado, resultado);
	}
	
	@Test
	public void getTotalCarsTest() {
		//Arrange
		parqueadero = new Parqueadero((short)5,(short)5);
		short valorEsperado = 5; 
		//Act
		short resultado = parqueadero.getTotalCars();
		//Assert
		Assert.assertEquals(valorEsperado, resultado);
	}
	
	@Test
	public void getTotalMotorbikeTest() {
		//Arrange
		parqueadero = new Parqueadero((short)5,(short)5);
		short valorEsperado = 5; 
		//Act
		short resultado = parqueadero.getTotalMotorbikes();
		//Assert
		Assert.assertEquals(valorEsperado, resultado);
	}
	
	@Test
	public void hayCupoCarro() {
		//Arrange
		parqueadero = new Parqueadero((short)5,(short)5);
		//Act
		boolean resultado = parqueadero.hayCupoCarro();
		//Assert
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void noHayCupoCarro() {
		//Arrange
		parqueadero = new Parqueadero((short)20,(short)5);
		//Act
		boolean resultado = parqueadero.hayCupoCarro();
		//Assert
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void hayCupoMotos() {
		//Arrange
		parqueadero = new Parqueadero((short)5,(short)5);
		//Act
		boolean resultado = parqueadero.hayCupoMoto();
		//Assert
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void noHayCupoMotos() {
		//Arrange
		parqueadero = new Parqueadero((short)20,(short)20);
		//Act
		boolean resultado = parqueadero.hayCupoMoto();
		//Assert
		Assert.assertFalse(resultado);
	}
}
