package com.ceiba.estacionamiento.dominio;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.estacionamiento.crud.VehiculoCRUD;
import com.ceiba.estacionamiento.dominio.Parqueadero;
import com.ceiba.estacionamiento.dominio.Registro;
import com.ceiba.estacionamiento.dominio.Tiempo;

import org.junit.Assert;
import org.junit.Before;

public class RegistroTest {
	
	@InjectMocks
	private Registro registro;
	
	@Mock
	private VehiculoCRUD vehiculoCRUD;
	
	@Mock
	private Parqueadero parqueadero;
	
	@Mock
	private Validaciones validaciones;
	
	@Mock
	private ActualizarVehiculo actualizarVehiculo;
	
	private FabricaVehiculos fabricaVehiculos = new FabricaVehiculos();
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	private Tiempo tiempo = new Tiempo();
	
	@Test
	public void registrarTest() {
		
		//Arrage
		String placa = "EHG44A";
		String tipo = "moto";
		String cilindraje = "125";
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(validaciones.validarVehiculosParqueados(Mockito.anyString(),Mockito.any(Parqueadero.class),Mockito.anyString())).thenReturn(null);
		Mockito.when(vehiculoCRUD.guardar(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		Mockito.when(actualizarVehiculo.actualizar(Mockito.anyString(), Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(null);
		String resultado = registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void registrarTestVehiculoYaIngreso() {
		
		//Arrage
		String placa = "EHG44A";
		String tipo = "moto";
		String cilindraje = "125";
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(validaciones.validarVehiculosParqueados(Mockito.anyString(),Mockito.any(Parqueadero.class),Mockito.anyString())).thenReturn("El vehiculo ya ingreso");
		Mockito.when(vehiculoCRUD.guardar(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		Mockito.when(actualizarVehiculo.actualizar(Mockito.anyString(), Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(null);
		String resultado = registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
		
		//Assert
		Assert.assertEquals("El vehiculo ya ingreso", resultado);
	}
	
	@Test
	public void registrarTestNoHayCupo() {
		
		//Arrage
		String placa = "EHG44A";
		String tipo = "moto";
		String cilindraje = "125";
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(validaciones.validarVehiculosParqueados(Mockito.anyString(),Mockito.any(Parqueadero.class),Mockito.anyString())).thenReturn("No hay cupo");
		Mockito.when(vehiculoCRUD.guardar(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		Mockito.when(actualizarVehiculo.actualizar(Mockito.anyString(), Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(null);
		String resultado = registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
		
		//Assert
		Assert.assertEquals("No hay cupo", resultado);
	}
	

	@Test
	public void actualizarVehiculo() {
		
		//Arrage
		String placa = "EHG44A";
		String tipo = "moto";
		String cilindraje = "125";
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(validaciones.validarVehiculosParqueados(Mockito.anyString(),Mockito.any(Parqueadero.class),Mockito.anyString())).thenReturn(null);
		Mockito.when(vehiculoCRUD.guardar(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		Mockito.when(actualizarVehiculo.actualizar(Mockito.anyString(), Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn("Registro realizado");
		String resultado = registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	

	@Test
	public void registrarTest2() {
		
		//Arrage
		String placa = "EHG44A";
		String tipo = "carro";
		String cilindraje = "0";
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(validaciones.validarVehiculosParqueados(Mockito.anyString(),Mockito.any(Parqueadero.class),Mockito.anyString())).thenReturn(null);
		Mockito.when(vehiculoCRUD.guardar(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		Mockito.when(actualizarVehiculo.actualizar(Mockito.anyString(), Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(null);
		String resultado = registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void registrarTest2VehiculoYaIngreso() {
		
		//Arrage
		String placa = "EHG44A";
		String tipo = "carro";
		String cilindraje = "0";
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(validaciones.validarVehiculosParqueados(Mockito.anyString(),Mockito.any(Parqueadero.class),Mockito.anyString())).thenReturn("El vehiculo ya ingreso");
		Mockito.when(vehiculoCRUD.guardar(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		Mockito.when(actualizarVehiculo.actualizar(Mockito.anyString(), Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(null);
		String resultado = registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
		
		//Assert
		Assert.assertEquals("El vehiculo ya ingreso", resultado);
	}
	
	@Test
	public void registrarTest2NoHayCupo() {
		
		//Arrage
		String placa = "EHG44A";
		String tipo = "carro";
		String cilindraje = "0";
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(validaciones.validarVehiculosParqueados(Mockito.anyString(),Mockito.any(Parqueadero.class),Mockito.anyString())).thenReturn("No hay cupo");
		Mockito.when(vehiculoCRUD.guardar(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		Mockito.when(actualizarVehiculo.actualizar(Mockito.anyString(), Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(null);
		String resultado = registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
		
		//Assert
		Assert.assertEquals("No hay cupo", resultado);
	}
	

	@Test
	public void registrarTest2ErroRegistroMoto() {
		
		//Arrage
		String placa = "EHG44A";
		String tipo = "carro";
		String cilindraje = "0";
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(validaciones.validarVehiculosParqueados(Mockito.anyString(),Mockito.any(Parqueadero.class),Mockito.anyString())).thenReturn(null);
		Mockito.when(vehiculoCRUD.guardar(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		Mockito.when(actualizarVehiculo.actualizar(Mockito.anyString(), Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn("Este vehiculo ya se registro como un carro");
		String resultado = registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
		
		//Assert
		Assert.assertEquals("Este vehiculo ya se registro como un carro", resultado);
	}
	
	@Test
	public void registrarTest2ErroRegistroCarro() {
		
		//Arrage
		String placa = "EHG44A";
		String tipo = "moto";
		String cilindraje = "0";
		Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(validaciones.validarVehiculosParqueados(Mockito.anyString(),Mockito.any(Parqueadero.class),Mockito.anyString())).thenReturn(null);
		Mockito.when(vehiculoCRUD.guardar(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		Mockito.when(actualizarVehiculo.actualizar(Mockito.anyString(), Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn("Este vehiculo ya se registro como una moto");
		String resultado = registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
		
		//Assert
		Assert.assertEquals("Este vehiculo ya se registro como una moto", resultado);
	}
	
}
