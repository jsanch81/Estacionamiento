package com.ceiba.Parqueadero.classes;


import org.junit.Test;

import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class VigilanteTest {


	@Test
	public void CrearVigilante() {
		// Arrange
		Vigilante vigilante = new Vigilante("jose","123456");
		
		//Act
		String name = vigilante.getName();
		//Assert
		Assert.assertEquals(name, "jose");
	}
	
}
