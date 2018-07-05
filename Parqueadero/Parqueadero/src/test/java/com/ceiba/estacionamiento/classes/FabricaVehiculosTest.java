package com.ceiba.estacionamiento.classes;

import org.junit.Assert;
import org.junit.Test;

public class FabricaVehiculosTest {

	private FabricaVehiculos fabricaVehiculos = new FabricaVehiculos();
	
	@Test
	public void crearVehiculoTestCarro() {
		//Arrange
		String cilindraje = null;
		String placa = "EHG44B";
		//Arrange
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa);
		//
		Assert.assertNotNull(vehiculo);
	}
	
	@Test
	public void crearVehiculoTestMoto() {
		//Arrange
		String cilindraje = "125";
		String placa = "EHG44B";
		//Arrange
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa);
		//
		Assert.assertNotNull(vehiculo);
	}
}
