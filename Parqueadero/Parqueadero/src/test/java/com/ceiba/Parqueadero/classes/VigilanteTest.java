package com.ceiba.Parqueadero.classes;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VigilanteTest {

	@Autowired
	private Vigilante vigilante;
	@Mock
	private Registro registro;
	@Mock
	private Tiempo tiempo;
	
	
	
	@Test
	public void registroVigilante() {
		// Arrange
		String placa = "EHG44B";
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrar(Mockito.any(Parqueadero.class), Mockito.anyBoolean(), Mockito.any(Vehiculo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(6);		
		String resultado = vigilante.registrar(new Parqueadero(), map);
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void registroVigilante2() {
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrar(Mockito.any(Parqueadero.class), Mockito.anyBoolean(), Mockito.any(Vehiculo.class))).thenReturn("No puede ingresar hoy");
		Mockito.when(tiempo.getDayWeek()).thenReturn(6);		
		String resultado = vigilante.registrar(new Parqueadero(), map);
		//Assert
		Assert.assertEquals("No puede ingresar hoy", resultado);
	}
}
