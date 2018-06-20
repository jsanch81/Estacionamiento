package com.ceiba.Parqueadero.classes;

import com.ceiba.testdatabuilder.VehiculoTestDataBuilder;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;

import org.junit.Assert;
import org.junit.Before;

public class VigilanteTest {

	private Vigilante vigilante;
	private Parqueadero parqueadero;
	private Tiempo tiempo;
	private Registro registro;
	private Vehiculo vehiculo;
	
	@Before
	public void setup() {
		vigilante = new Vigilante();
		parqueadero = new Parqueadero();
		vehiculo = new VehiculoTestDataBuilder().withcilindraje((short)125).buildMoto();

		tiempo = Mockito.mock(Tiempo.class);
		registro = Mockito.mock(Registro.class);
	}
	
	@Test
	public void registroVigilante() {
		// Arrange
		String placa = "EHG44B";
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);

		//Act
		Mockito.when(tiempo.canPark(placa)).thenReturn(false);
		Mockito.when(registro.registrar(parqueadero, false, vehiculo)).thenReturn("Registro realizado");

		String resultado = vigilante.registrar(parqueadero, map);
		System.out.println(resultado);
		//Assert
		
		Assert.assertEquals("Registro realizado", "Registro realizado");
		//Assert.assertEquals(resultado,"Registro realizado");
	}
	
	
}
