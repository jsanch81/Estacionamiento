package com.ceiba.parqueadero.crud;


import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.parqueadero.classes.Tiempo;
import com.ceiba.parqueadero.crud.VehiculoCRUD;
import com.ceiba.parqueadero.model.VehiculoModel;
import com.ceiba.parqueadero.model.Vehiculos;
import com.ceiba.parqueadero.repository.ParqueaderoRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.junit.Assert;
import org.junit.Before;


public class VehiculoCRUDTest {

	@InjectMocks
	private VehiculoCRUD vehiculoCRUD;
	
	@Mock
	private VehiculoModel vehiculoModel;
	
	@Mock
	private  ParqueaderoRepository parqueaderoRepository;
	
	@Mock
	private Tiempo tiempo;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testSave() {
		
		//Arrange
		String placa = "EHG44B";
		String tipo = "carro";
		short cilindraje = 125;
		Calendar calendar = Calendar.getInstance();
		
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
		Optional<VehiculoModel> vehiculoM = Optional.of(vehiculoModel);

		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenReturn(vehiculoM);
		Mockito.when(vehiculoModel.getEstado()).thenReturn("true");
		boolean resultado = vehiculoCRUD.validateVehiculo(placa);
		
		//Assert
		
		Assert.assertTrue(resultado);
		
	}
	
	@Test
	public void validateVehiculoError() {
		
		//Arrange
		String placa = "EHG44B";

		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenThrow(IllegalArgumentException.class);
		Mockito.when(vehiculoModel.getEstado()).thenReturn("true");
		boolean resultado = vehiculoCRUD.validateVehiculo(placa);
		
		//Assert
		
		Assert.assertFalse(resultado);
		
	}
	
	@Test
	public void validateNotVehiculo() {
		
		//Arrange
		String placa = "EHG44B";
		Optional<VehiculoModel> vehiculoM = Optional.of(vehiculoModel);

		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenReturn(vehiculoM);
		Mockito.when(vehiculoModel.getEstado()).thenReturn("false");
		boolean resultado = vehiculoCRUD.validateVehiculo(placa);
		
		//Assert	
		Assert.assertFalse(resultado);
		
	}
	
	@Test
	public void findVehiculo() {		
		//Arrange
		String placa = "EHG44B";
		Optional<VehiculoModel> vehiculoM = Optional.of(vehiculoModel);
		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenReturn(vehiculoM);
		VehiculoModel resultado = vehiculoCRUD.findVehiculo(placa);
		System.out.println(resultado);
		//Assert
		Assert.assertNotNull(resultado);
	}
	
	
	@Test
	public void NotFindVehiculo() {		
		//Arrange
		String placa = "EHG44B";
		
		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenThrow(IllegalArgumentException.class);
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
		Optional<VehiculoModel> vehiculoM = Optional.of(vehiculoModel);

		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenReturn(vehiculoM);
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

		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenThrow(IllegalArgumentException.class);
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
		Optional<VehiculoModel> vehiculoM = Optional.of(vehiculoModel);

		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenReturn(vehiculoM);
		Mockito.when(tiempo.getDate()).thenReturn(calendar.getTime());
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		Mockito.when(parqueaderoRepository.save(Mockito.any(VehiculoModel.class))).thenThrow(NullPointerException.class);
		boolean resultado = vehiculoCRUD.updateVehiculo(placa, tiempo);
		
		//Assert
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void updateSalidaVehiculoTest() {
		
		//Arrange
		String placa = "EHG44B";
		Optional<VehiculoModel> vehiculoM = Optional.of(vehiculoModel);

		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenReturn(vehiculoM);
		Mockito.when(parqueaderoRepository.save(Mockito.any(VehiculoModel.class))).thenReturn(vehiculoModel);
		boolean resultado = vehiculoCRUD.updateSalidaVehiculo(placa);
		
		//Assert
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void updateSalidaVehiculoTestErrorNull() {
		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setVehiculoModel(vehiculoModel);
		Optional<VehiculoModel> vehiculoM = Optional.of(vehiculoModel);

		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenReturn(vehiculoM);
		Mockito.when(parqueaderoRepository.save(Mockito.any(VehiculoModel.class))).thenThrow(NullPointerException.class);
		boolean resultado = vehiculoCRUD.updateSalidaVehiculo(placa);
		
		//Assert
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void updateSalidaVehiculoTestErrorEntity() {
		
		//Arrange
		String placa = "EHG44B";
		vehiculoCRUD.setVehiculoModel(vehiculoModel);

		//Act
		Mockito.when(parqueaderoRepository.findById(Mockito.anyString())).thenThrow(IllegalArgumentException.class);
		Mockito.when(parqueaderoRepository.save(Mockito.any(VehiculoModel.class))).thenReturn(vehiculoModel);
		boolean resultado = vehiculoCRUD.updateSalidaVehiculo(placa);
		
		//Assert
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void vehiculosIntoParkingTest() {
		 //Arrange
		 List<Vehiculos> listVehiculos = new ArrayList<Vehiculos>();
		 List<VehiculoModel> listIntoVehiculos = new ArrayList<VehiculoModel>();
		 listIntoVehiculos.add(vehiculoModel);
		 listVehiculos.add(new Vehiculos("EHG44B","24/08/1997","carro"));
		 
		 //Act
		 Mockito.when(parqueaderoRepository.findAll()).thenReturn(listIntoVehiculos);
		 Mockito.when(vehiculoModel.getEstado()).thenReturn("true");
		 Mockito.when(vehiculoModel.getFechaIngreso()).thenReturn(new Date());
		 Mockito.when(vehiculoModel.getPlaca()).thenReturn("EHG44B");
		 Mockito.when(vehiculoModel.getTipo()).thenReturn("carro");
		 Mockito.when(tiempo.dateToString(Mockito.any(Date.class))).thenReturn("24/08/1997");
		 List<Vehiculos> resultado = vehiculoCRUD.vehiculosIntoParking(tiempo);
		 
		 //Assert
		 Assert.assertEquals(listVehiculos.get(0).getPlaca(), resultado.get(0).getPlaca());
		 Assert.assertEquals(listVehiculos.get(0).getTipo(), resultado.get(0).getTipo());
		 Assert.assertEquals(listVehiculos.get(0).getFechaIngreso(), resultado.get(0).getFechaIngreso());

	}
	
	@Test
	public void numCarsInParkingTestCarro() {
		
		//Arrange
		short[] salida = {1,0};
		List<VehiculoModel> listIntoVehiculos = new ArrayList<VehiculoModel>();
		listIntoVehiculos.add(vehiculoModel);
		
		//Act
		Mockito.when(parqueaderoRepository.findAll()).thenReturn(listIntoVehiculos);
		Mockito.when(vehiculoModel.getEstado()).thenReturn("true");
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		
		short[] resultado = vehiculoCRUD.numCarsInParking();
		// Assert
		
		Assert.assertArrayEquals(salida, resultado);
	}
	
	@Test
	public void numCarsInParkingTestMoto() {
		
		//Arrange
		short[] salida = {1,0};
		List<VehiculoModel> listIntoVehiculos = new ArrayList<VehiculoModel>();
		listIntoVehiculos.add(vehiculoModel);
		
		//Act
		Mockito.when(parqueaderoRepository.findAll()).thenReturn(listIntoVehiculos);
		Mockito.when(vehiculoModel.getEstado()).thenReturn("true");
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		
		short[] resultado = vehiculoCRUD.numCarsInParking();
		// Assert
		
		Assert.assertArrayEquals(salida, resultado);
	}
	
}
