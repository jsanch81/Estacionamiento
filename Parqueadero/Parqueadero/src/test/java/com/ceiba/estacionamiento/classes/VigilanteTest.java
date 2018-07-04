package com.ceiba.estacionamiento.classes;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.estacionamiento.classes.Carro;
import com.ceiba.estacionamiento.classes.CobroSalidaParqueadero;
import com.ceiba.estacionamiento.classes.Moto;
import com.ceiba.estacionamiento.classes.Parqueadero;
import com.ceiba.estacionamiento.classes.Registro;
import com.ceiba.estacionamiento.classes.Tiempo;
import com.ceiba.estacionamiento.classes.Vigilante;

import org.junit.Assert;
import org.junit.Before;


public class VigilanteTest {

	@InjectMocks
	private Vigilante vigilante;
	
	@Mock
	private Registro registro;
	
	@Mock
	private Tiempo tiempo;
	
	@Mock
	private CobroSalidaParqueadero cobro;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void registroVigilanteMoto() {
		// Arrange
		String placa = "EHG44B";
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		
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
		String placa = "MMM22B";
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		
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
		
		//Act
		Mockito.when(registro.registrarMoto(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(3);		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("no puede ingresar porque no esta en un dia habil", resultado);
	}
	
	@Test
	public void registroVigilanteCarro() {
		
		// Arrange
		String placa = "EHG44B";
		String cilindraje = "";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		
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
		
		//Act
		Mockito.when(registro.registrarCarro(Mockito.any(Parqueadero.class), Mockito.any(Carro.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(3);		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("no puede ingresar porque no esta en un dia habil", resultado);
	}
	
	@Test
	public void cobrarTest() {
		
		// Arrange
		String placa = "AHG44B";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		
		//Act
		Mockito.when(cobro.generarCobro(Mockito.anyString(), Mockito.any(Tiempo.class), Mockito.any(Parqueadero.class))).thenReturn(1000);
		int resultado = vigilante.cobrar(new Parqueadero(), map, tiempo);
		//Assert
		Assert.assertEquals(1000, resultado);
	}
	
	@Test
	public void registroVigilanteNullPlaca() {
		// Arrange
		String placa = null;
		String cilindraje = "125";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		
		//Act
		Mockito.when(registro.registrarMoto(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(6);		
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Debe de ingresar minimo la placa", resultado);
	}
	
}
