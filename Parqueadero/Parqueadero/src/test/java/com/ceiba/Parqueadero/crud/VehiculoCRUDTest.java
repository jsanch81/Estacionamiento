package com.ceiba.Parqueadero.crud;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.Parqueadero.classes.Tiempo;
import com.ceiba.Parqueadero.model.VehiculoModel;
import com.ceiba.Parqueadero.repository.ParqueaderoRepository;

import java.util.Calendar;

import javax.persistence.EntityNotFoundException;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehiculoCRUDTest {

	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	@Mock
	private VehiculoModel vehiculoModel;
	
	@Mock
	private  ParqueaderoRepository parqueaderoRepository;
	
	@Mock
	private Tiempo tiempo;
	
	@Test
	public void testSave() {
		
		//Arrange
		String placa = "EHG44B";
		String tipo = "carro";
		short cilindraje = 125;
		Calendar calendar = Calendar.getInstance();
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);
		vehiculoCRUD.setVehiculoModel(vehiculoModel);
		
		//Act
		Mockito.when(tiempo.getDate()).thenReturn(calendar.getTime());
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueaderoRepository.save(Mockito.any(VehiculoModel.class))).thenReturn(vehiculoModel);
		boolean resultado = vehiculoCRUD.save(placa, tipo, cilindraje, tiempo);
		
		//Assert
		Assert.assertTrue(resultado);
		
	}
	
	@Test
	public void testNotSave() {
		
		//Arrange
		String placa = "EHG44B";
		String tipo = "carro";
		short cilindraje = 125;
		Calendar calendar = Calendar.getInstance();
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);
		vehiculoCRUD.setVehiculoModel(vehiculoModel);
		
		//Act
		Mockito.when(tiempo.getDate()).thenReturn(calendar.getTime());
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueaderoRepository.save(Mockito.any(VehiculoModel.class))).thenThrow(NullPointerException.class);
		boolean resultado = vehiculoCRUD.save(placa, tipo, cilindraje, tiempo);
		
		//Assert
		Assert.assertFalse(resultado);
		
	}
	
	@Test
	public void findIntoParkingTest() {
		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);

		//Act
		Mockito.when(parqueaderoRepository.existsById(placa)).thenReturn(true);
		boolean resultado = vehiculoCRUD.findIntoParking(placa);
		
		//Assert
		Assert.assertTrue(resultado);
		
	}
	
	@Test
	public void findIntoParkingTestError() {
		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);

		//Act
		Mockito.when(parqueaderoRepository.existsById(placa)).thenThrow(IllegalArgumentException.class);
		boolean resultado = vehiculoCRUD.findIntoParking(placa);
		
		//Assert
		Assert.assertFalse(resultado);
		
	}
	
	@Test
	public void findNotIntoParkingTest() {
		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);

		//Act
		Mockito.when(parqueaderoRepository.existsById(placa)).thenReturn(false);
		boolean resultado = vehiculoCRUD.findIntoParking(placa);
		
		//Assert
		Assert.assertFalse(resultado);
		
	}
	
	@Test
	public void validateVehiculo() {
		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setVehiculoModel(vehiculoModel);
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);

		//Act
		Mockito.when(parqueaderoRepository.getOne(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getEstado()).thenReturn("true");
		boolean resultado = vehiculoCRUD.validateVehiculo(placa);
		
		//Assert
		
		Assert.assertTrue(resultado);
		
	}
	
	@Test
	public void validateVehiculoError() {
		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setVehiculoModel(vehiculoModel);
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);

		//Act
		Mockito.when(parqueaderoRepository.getOne(Mockito.anyString())).thenThrow(EntityNotFoundException.class);
		Mockito.when(vehiculoModel.getEstado()).thenReturn("true");
		boolean resultado = vehiculoCRUD.validateVehiculo(placa);
		
		//Assert
		
		Assert.assertFalse(resultado);
		
	}
	
	@Test
	public void validateNotVehiculo() {
		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setVehiculoModel(vehiculoModel);
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);

		//Act
		Mockito.when(parqueaderoRepository.getOne(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getEstado()).thenReturn("false");
		boolean resultado = vehiculoCRUD.validateVehiculo(placa);
		
		//Assert	
		Assert.assertFalse(resultado);
		
	}
	
	@Test
	public void findVehiculo() {		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);
		
		//Act
		Mockito.when(parqueaderoRepository.getOne(Mockito.anyString())).thenReturn(vehiculoModel);
		VehiculoModel resultado = vehiculoCRUD.findVehiculo(placa);
		
		//Assert
		Assert.assertNotNull(resultado);
	}
	
	
	@Test
	public void NotFindVehiculo() {		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);
		
		//Act
		Mockito.when(parqueaderoRepository.getOne(Mockito.anyString())).thenThrow(EntityNotFoundException.class);
		VehiculoModel resultado = vehiculoCRUD.findVehiculo(placa);
		System.out.println(resultado);
		
		//Assert
		Assert.assertNull(resultado);
	}
	
	@Test
	public void updateVehiculoTest() {
		
		//Arrange
		String placa = "EHG44B";
		Calendar calendar = Calendar.getInstance();
		vehiculoCRUD.setVehiculoModel(vehiculoModel);
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);

		//Act
		Mockito.when(parqueaderoRepository.getOne(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(tiempo.getDate()).thenReturn(calendar.getTime());
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueaderoRepository.save(Mockito.any(VehiculoModel.class))).thenReturn(vehiculoModel);
		boolean resultado = vehiculoCRUD.updateVehiculo(placa, tiempo);
		
		//Assert
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void updateVehiculoTestErrorGetOne() {
		
		//Arrange
		String placa = "EHG44B";
		Calendar calendar = Calendar.getInstance();
		vehiculoCRUD.setVehiculoModel(vehiculoModel);
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);

		//Act
		Mockito.when(parqueaderoRepository.getOne(Mockito.anyString())).thenThrow(EntityNotFoundException.class);
		Mockito.when(tiempo.getDate()).thenReturn(calendar.getTime());
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueaderoRepository.save(Mockito.any(VehiculoModel.class))).thenReturn(vehiculoModel);
		boolean resultado = vehiculoCRUD.updateVehiculo(placa, tiempo);
		
		//Assert
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void updateVehiculoTestErrorNull() {
		
		//Arrange
		String placa = "EHG44B";
		Calendar calendar = Calendar.getInstance();
		vehiculoCRUD.setVehiculoModel(vehiculoModel);
		vehiculoCRUD.setParqueaderoRepository(parqueaderoRepository);

		//Act
		Mockito.when(parqueaderoRepository.getOne(Mockito.anyString())).thenReturn(vehiculoModel);
		Mockito.when(tiempo.getDate()).thenReturn(calendar.getTime());
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueaderoRepository.save(Mockito.any(VehiculoModel.class))).thenThrow(NullPointerException.class);
		boolean resultado = vehiculoCRUD.updateVehiculo(placa, tiempo);
		
		//Assert
		Assert.assertFalse(resultado);
	}
	
	
}
