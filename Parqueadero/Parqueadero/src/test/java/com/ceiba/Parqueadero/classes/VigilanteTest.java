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
	public void registroVigilanteMoto() {
		// Arrange
		String placa = "EHG44B";
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrarMoto(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(6);		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaIngresoAMoto() {
		
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrarMoto(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(1);
		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaIngresoA2Moto() {
		
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrarMoto(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(2);		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaNoIngresoAMoto() {
		
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrarMoto(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(3);		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("no puede ingresar porque no está en un dia hábil", resultado);
	}
	
	@Test
	public void registroVigilanteCarro() {
		
		// Arrange
		String placa = "EHG44B";
		String cilindraje = "";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrarCarro(Mockito.any(Parqueadero.class), Mockito.any(Carro.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(6);		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaIngresoACarro() {
		
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrarCarro(Mockito.any(Parqueadero.class), Mockito.any(Carro.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(1);
		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaIngresoA2Carro() {
		
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrarCarro(Mockito.any(Parqueadero.class), Mockito.any(Carro.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(2);		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaNoIngresoACarro() {
		
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		vigilante.setRegistro(registro);
		vigilante.setTiempo(tiempo);
		
		//Act
		Mockito.when(registro.registrarCarro(Mockito.any(Parqueadero.class), Mockito.any(Carro.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(3);		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("no puede ingresar porque no está en un dia hábil", resultado);
	}
}
