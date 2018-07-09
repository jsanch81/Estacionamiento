package com.ceiba.estacionamiento.factory;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.estacionamiento.productos.PrecioParqueoVehiculo;

public class PrecioParqueoVehiculosTest {

	private CostoParqueoVehiculos costoParqueoVehiculos = new CostoParqueoVehiculos();
	
	@Test
	public void crearCosoCarro() {
		//Arrange
		String tipo = "carro";
		short cilindraje = 0;
		//Act
		PrecioParqueoVehiculo resultado = costoParqueoVehiculos.createProducto(tipo, cilindraje);
		
		//Assert
		Assert.assertNotNull(resultado);
		
	}
	
	@Test
	public void crearCosoMoto() {
		//Arrange
		String tipo = "moto";
		short cilindraje = 125;
		//Act
		PrecioParqueoVehiculo resultado = costoParqueoVehiculos.createProducto(tipo, cilindraje);
		
		//Assert
		Assert.assertNotNull(resultado);
		
	}
	
	@Test
	public void crearCosoMotoAltoCilindraje() {
		//Arrange
		String tipo = "moto";
		short cilindraje = 600;
		//Act
		PrecioParqueoVehiculo resultado = costoParqueoVehiculos.createProducto(tipo, cilindraje);
		
		//Assert
		Assert.assertNotNull(resultado);
		
	}
	
	@Test
	public void crearVehiculoNoExistente() {
		//Arrange
		String tipo = "avion";
		short cilindraje = 600;
		//Act
		PrecioParqueoVehiculo resultado = costoParqueoVehiculos.createProducto(tipo, cilindraje);
		
		//Assert
		Assert.assertNull(resultado);
		
	}
	
	
}
