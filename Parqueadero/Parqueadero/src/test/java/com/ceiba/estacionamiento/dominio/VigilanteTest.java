package com.ceiba.estacionamiento.dominio;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.estacionamiento.dominio.Carro;
import com.ceiba.estacionamiento.dominio.CobroSalidaParqueadero;
import com.ceiba.estacionamiento.dominio.Moto;
import com.ceiba.estacionamiento.dominio.Parqueadero;
import com.ceiba.estacionamiento.dominio.Registro;
import com.ceiba.estacionamiento.dominio.Tiempo;
import com.ceiba.estacionamiento.dominio.Vigilante;

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
	private FabricaVehiculos fabricaVehiculo;
	
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
		String tipo = "moto";

		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);
		Vehiculo vehiculo = new FabricaVehiculos().crearVehiculo(cilindraje, placa, tipo);
		
		//Act
		Mockito.when(registro.registrarVehiculo(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(6);	
		Mockito.when(fabricaVehiculo.crearVehiculo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(vehiculo);

		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaIngresoAMoto() {
		
		// Arrange
		String placa = "MMM22B";
		String cilindraje = "125";
		String tipo = "moto";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);
		Vehiculo vehiculo = new FabricaVehiculos().crearVehiculo(cilindraje, placa, tipo);
		
		//Act
		Mockito.when(registro.registrarVehiculo(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(1);
		Mockito.when(fabricaVehiculo.crearVehiculo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(vehiculo);

		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaIngresoA2Moto() {
		
		// Arrange
				String placa = "EHG44B";
				String cilindraje = "125";
				String tipo = "moto";
				Map<String,String> map = new HashMap<String,String>();
				map.put("placa", placa);
				map.put("cilindraje", cilindraje);
				map.put("tipo", tipo);
				Vehiculo vehiculo = new FabricaVehiculos().crearVehiculo(cilindraje, placa, tipo);
				//Act
				Mockito.when(registro.registrarVehiculo(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
				Mockito.when(tiempo.getDayWeek()).thenReturn(6);		
				Mockito.when(fabricaVehiculo.crearVehiculo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(vehiculo);
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
		Mockito.when(registro.registrarVehiculo(Mockito.any(Parqueadero.class), Mockito.any(Moto.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
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
		String tipo = "carro";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);
		Vehiculo vehiculo = new FabricaVehiculos().crearVehiculo(cilindraje, placa, tipo);
		//Act
		Mockito.when(registro.registrarVehiculo(Mockito.any(Parqueadero.class), Mockito.any(Carro.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(6);		
		Mockito.when(fabricaVehiculo.crearVehiculo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(vehiculo);
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaIngresoACarro() {
		
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "";
		String tipo = "carro";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);
		Vehiculo vehiculo = new FabricaVehiculos().crearVehiculo(cilindraje, placa, tipo);
		
		//Act
		Mockito.when(registro.registrarVehiculo(Mockito.any(Parqueadero.class), Mockito.any(Carro.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(1);
		Mockito.when(fabricaVehiculo.crearVehiculo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(vehiculo);

		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaIngresoA2Carro() {
		
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "";
		String tipo = "carro";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);
		Vehiculo vehiculo = new FabricaVehiculos().crearVehiculo(cilindraje, placa, tipo);
		
		//Act
		Mockito.when(registro.registrarVehiculo(Mockito.any(Parqueadero.class), Mockito.any(Carro.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(2);	
		Mockito.when(fabricaVehiculo.crearVehiculo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(vehiculo);

		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void fechaNoIngresoACarro() {
		
		// Arrange
		String placa = "AHG44B";
		String cilindraje = "";
		String tipo = "carro";
		Map<String,String> map = new HashMap<String,String>();
		map.put("placa", placa);
		map.put("cilindraje", cilindraje);
		map.put("tipo", tipo);
		Vehiculo vehiculo = new FabricaVehiculos().crearVehiculo(cilindraje, placa, tipo);
		
		//Act
		Mockito.when(registro.registrarVehiculo(Mockito.any(Parqueadero.class), Mockito.any(Carro.class), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		Mockito.when(tiempo.getDayWeek()).thenReturn(3);
		Mockito.when(fabricaVehiculo.crearVehiculo(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(vehiculo);

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
		Mockito.when(cobro.generarCobro(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(1000);
		int resultado = vigilante.cobrar(map, tiempo);
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
		String resultado = vigilante.registrar(new Parqueadero(), map, tiempo);
		
		//Assert
		Assert.assertEquals("Debe de ingresar minimo la placa", resultado);
	}
	
}
