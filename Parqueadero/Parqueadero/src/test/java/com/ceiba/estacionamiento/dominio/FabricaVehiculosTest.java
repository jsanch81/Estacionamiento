package com.ceiba.estacionamiento.dominio;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.estacionamiento.dominio.FabricaVehiculos;
import com.ceiba.estacionamiento.dominio.Vehiculo;

public class FabricaVehiculosTest {

	private FabricaVehiculos fabricaVehiculos = new FabricaVehiculos();
	
	@Test
	public void crearVehiculoTestCarro() {
		//Arrange
		String cilindraje = null;
		String placa = "EHG44B";
		String tipo = "carro";
		//Arrange
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		//Assert
		Assert.assertNotNull(vehiculo);
	}
	
	@Test
	public void crearVehiculoTestMoto() {
		//Arrange
		String cilindraje = "125";
		String placa = "EHG44B";
		String tipo = "moto";
		//Arrange
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		//Assert
		Assert.assertNotNull(vehiculo);
	}
}
