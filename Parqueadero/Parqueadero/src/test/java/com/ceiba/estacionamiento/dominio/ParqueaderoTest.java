package com.ceiba.estacionamiento.dominio;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.estacionamiento.dominio.Parqueadero;


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
	public void hayCupoCarro() {
		//Arrange
		short [] cupo = {2,4};
		String tipo = "carro";
		//Act
		boolean resultado = parqueadero.hayCupoVehiulo(cupo, tipo);
		//Assert
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void noHayCupoCarro() {
		//Arrange
		short [] cupo = {2,20};
		String tipo = "carro";
		//Act
		boolean resultado = parqueadero.hayCupoVehiulo(cupo, tipo);
		//Assert
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void hayCupoMotos() {
		//Arrange
		short [] cupo = {2,4};
		String tipo = "moto";
		//Act
		boolean resultado = parqueadero.hayCupoVehiulo(cupo, tipo);
		//Assert
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void noHayCupoMotos() {
		//Arrange
		short [] cupo = {10,4};
		String tipo = "moto";
		//Act
		boolean resultado = parqueadero.hayCupoVehiulo(cupo, tipo);
		//Assert
		Assert.assertFalse(resultado);
	}
}
