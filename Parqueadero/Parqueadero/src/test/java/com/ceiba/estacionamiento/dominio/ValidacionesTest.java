package com.ceiba.estacionamiento.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.estacionamiento.crud.VehiculoCRUD;
import com.ceiba.estacionamiento.modelos.VehiculoModel;


public class ValidacionesTest {

	@InjectMocks
	private Validaciones validaciones;
	
	@Mock
	private Parqueadero parqueadero;
	
	@Mock
	private VehiculoCRUD vehiculoCRUD;
	
	@Mock
	private VehiculoModel vehiculoModel;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void validarVehiculosEnParqueadetoNoCupoTest() {
		//Arrange
		String placa = "EHG44B";
		String tipo = "moto";
		
		//Act
		Mockito.when(parqueadero.hayCupoVehiulo(Mockito.any(), Mockito.anyString())).thenReturn(false);
		
		String resultado = validaciones.validarVehiculosEnParqueadero(placa, parqueadero, tipo);
		
		//Assert
		Assert.assertEquals("No hay cupo", resultado);
		
		
	}
	
	@Test
	public void validarVehiculosEnParqueadetoYaIngreso() {
		//Arrange
		String placa = "EHG44B";
		String tipo = "moto";
		
		//Act
		Mockito.when(parqueadero.hayCupoVehiulo(Mockito.any(), Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(placa)).thenReturn(true);
		String resultado = validaciones.validarVehiculosEnParqueadero(placa, parqueadero, tipo);
		
		//Assert
		Assert.assertEquals("El vehiculo ya ingreso", resultado);
		
		
	}
	
	@Test
	public void validarVehiculosEnParqueadetoValido1() {
		//Arrange
		String placa = "EHG44B";
		String tipo = "moto";
		
		//Act
		Mockito.when(parqueadero.hayCupoVehiulo(Mockito.any(), Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(false);
		String resultado = validaciones.validarVehiculosEnParqueadero(placa, parqueadero, tipo);
		
		//Assert
		Assert.assertNull(resultado);
		
		
	}
	
	@Test
	public void validarVehiculosEnParqueadetoValido2() {
		//Arrange
		String placa = "EHG44B";
		String tipo = "moto";
		
		//Act
		Mockito.when(parqueadero.hayCupoVehiulo(Mockito.any(), Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(placa)).thenReturn(false);

		String resultado = validaciones.validarVehiculosEnParqueadero(placa, parqueadero, tipo);
		
		//Assert
		Assert.assertNull(resultado);
		
		
	}
	
	@Test
	public void ValidarVehiculosRegistrados() {
		//Arrange
		String placa = "EHG44B";
		String tipo = "moto";
		//Act
		Mockito.when(vehiculoCRUD.findVehiculo(placa)).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		boolean resultado = validaciones.validarVehiculosYaRegistrados(placa, tipo);
		//Assert
		Assert.assertTrue(resultado);
	
	}
	
	@Test
	public void ValidarVehiculosNoRegistrados() {
		//Arrange
		String placa = "EHG44B";
		String tipo = "moto";
		//Act
		Mockito.when(vehiculoCRUD.findVehiculo(placa)).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn(null);
		boolean resultado = validaciones.validarVehiculosYaRegistrados(placa, tipo);
		//Assert
		Assert.assertFalse(resultado);
	
	}
	
	@Test
	public void VelidarVehiculosIngresadosAntes() {
		//Arrange
		String placa = "EHG44B";
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(placa)).thenReturn(false);
		
		boolean resultado = validaciones.validarVehiculosIngresadosAntes(placa);
		//Assert
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void validarVehiculosNoIngresadosAntes() {
		//Arrange
		String placa = "EHG44B";
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(false);
		
		boolean resultado = validaciones.validarVehiculosIngresadosAntes(placa);
		//Assert
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void validarVehiculosNoIngresadosAntes2() {
		//Arrange
		String placa = "EHG44B";
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(placa)).thenReturn(true);

		boolean resultado = validaciones.validarVehiculosIngresadosAntes(placa);
		//Assert
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void validarSalidaVehiculoNoValido() {
		//Arrange
		String placa = "EHG44B";
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(placa)).thenReturn(false);
		Mockito.when(vehiculoCRUD.validateVehiculo(placa)).thenReturn(false);
		
		long resultado = validaciones.validarSalidaVehiculo(placa);
		//Assert
		Assert.assertEquals(-1,resultado);
	}
	@Test
	public void validarSalidaVehiculoNoValido2() {
		//Arrange
		String placa = "EHG44B";
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(placa)).thenReturn(false);
		Mockito.when(vehiculoCRUD.validateVehiculo(placa)).thenReturn(true);
		
		long resultado = validaciones.validarSalidaVehiculo(placa);
		//Assert
		Assert.assertEquals(-1,resultado);
	}
	
	@Test
	public void validarSalidaVehiculoNoValido3() {
		//Arrange
		String placa = "EHG44B";
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(placa)).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(placa)).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(placa)).thenReturn(false);
		long resultado = validaciones.validarSalidaVehiculo(placa);
		//Assert
		Assert.assertEquals(-2,resultado);
	}
	
	@Test
	public void validarSalidaVehiculoValido() {
		//Arrange
		String placa = "EHG44B";
		
		//Act
		Mockito.when(vehiculoCRUD.findIntoParking(placa)).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(placa)).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateSalidaVehiculo(placa)).thenReturn(true);
		long resultado = validaciones.validarSalidaVehiculo(placa);
		//Assert
		Assert.assertEquals(0,resultado);
	}
	
}
