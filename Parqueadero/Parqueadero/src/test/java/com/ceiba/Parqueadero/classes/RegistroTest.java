package com.ceiba.Parqueadero.classes;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ceiba.Parqueadero.classes.Carro;
import com.ceiba.Parqueadero.classes.Moto;
import com.ceiba.Parqueadero.classes.Parqueadero;
import com.ceiba.Parqueadero.classes.Registro;
import com.ceiba.Parqueadero.classes.Tiempo;
import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.model.VehiculoModel;

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
	private Carro carro;
	
	@Mock
	private Moto moto;
	
	@Mock
	private VehiculoModel vehiculoModel;
	

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	private Tiempo tiempo = new Tiempo();
	
	@Test
	public void registrarTest() {
		
		//Arrage
		String placa = "EHG44A";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(carro.getPlaca()).thenReturn(placa);
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoCarro()).thenReturn(true);
		Mockito.doNothing().when(parqueadero).setTotalCars(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.numCarsInParking()).thenReturn(valor);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(),  Mockito.any(Tiempo.class))).thenReturn(true);
		String resultado = registro.registrarCarro(parqueadero, carro, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void registrarTestVehiculoYaIngreso() {
		
		//Arrage
		String placa = "EHG441";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(carro.getPlaca()).thenReturn(placa);
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoCarro()).thenReturn(true);
		Mockito.doNothing().when(parqueadero).setTotalCars(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.numCarsInParking()).thenReturn(valor);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(), Mockito.any(Tiempo.class))).thenReturn(true);
		String resultado = registro.registrarCarro(parqueadero, carro,tiempo);
		
		//Assert
		Assert.assertEquals("El vehiculo ya ingreso", resultado);
	}
	
	@Test
	public void registrarTestNoHayCupo() {
		
		//Arrage
		String placa = "EHG441";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(carro.getPlaca()).thenReturn(placa);
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoCarro()).thenReturn(false);
		Mockito.doNothing().when(parqueadero).setTotalCars(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.numCarsInParking()).thenReturn(valor);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(), Mockito.any(Tiempo.class))).thenReturn(true);
		String resultado = registro.registrarCarro(parqueadero, carro,tiempo);
		
		//Assert
		Assert.assertEquals("No hay cupo", resultado);
	}
	
	@Test
	public void registrarTestErroBaseDeDatos() {
		
		//Arrage
		String placa = "EHG441";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(carro.getPlaca()).thenReturn(placa);
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoCarro()).thenReturn(true);
		Mockito.doNothing().when(parqueadero).setTotalCars(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.numCarsInParking()).thenReturn(valor);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.findVehiculo(placa)).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("carro");
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(), Mockito.any(Tiempo.class))).thenReturn(true);
		String resultado = registro.registrarCarro(parqueadero, carro, tiempo);
		
		//Assert
		Assert.assertEquals("Error al guardar en la base de datos", resultado);
	}
	
	public void registrarTestErroBaseDeDatos2() {
		
		//Arrage
		String placa = "EHG441";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(carro.getPlaca()).thenReturn(placa);
		Mockito.when(parqueadero.getTotalCars()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoCarro()).thenReturn(true);
		Mockito.doNothing().when(parqueadero).setTotalCars(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.numCarsInParking()).thenReturn(valor);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(), Mockito.any(Tiempo.class))).thenReturn(false);
		String resultado = registro.registrarCarro(parqueadero, carro, tiempo);
		
		//Assert
		Assert.assertEquals("Error al guardar en la base de datos", resultado);
	}
	
	@Test
	public void registrarTest2() {
		
		//Arrage
		String placa = "EHG441";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(moto.getPlaca()).thenReturn(placa);
		Mockito.when(moto.getCilindraje()).thenReturn((short)125);
		Mockito.when(parqueadero.getTotalMotorbikes()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoMoto()).thenReturn(true);
		Mockito.doNothing().when(parqueadero).setTotalMotorbikes(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(), Mockito.any(Tiempo.class))).thenReturn(true);
		String resultado = registro.registrarMoto(parqueadero, moto, tiempo);
		
		//Assert
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	@Test
	public void registrarTest2VehiculoYaIngreso() {
		
		//Arrage
		String placa = "EHG441";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(moto.getPlaca()).thenReturn(placa);
		Mockito.when(moto.getCilindraje()).thenReturn((short)125);
		Mockito.when(parqueadero.getTotalMotorbikes()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoMoto()).thenReturn(true);
		Mockito.doNothing().when(parqueadero).setTotalMotorbikes(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.numCarsInParking()).thenReturn(valor);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(), Mockito.any(Tiempo.class))).thenReturn(true);
		String resultado = registro.registrarMoto(parqueadero, moto, tiempo);
		
		//Assert
		Assert.assertEquals("El vehiculo ya ingreso", resultado);
	}
	
	@Test
	public void registrarTest2NoHayCupo() {
		
		//Arrage
		String placa = "EHG441";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(moto.getPlaca()).thenReturn(placa);
		Mockito.when(moto.getCilindraje()).thenReturn((short)125);
		Mockito.when(parqueadero.getTotalMotorbikes()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoMoto()).thenReturn(false);
		Mockito.doNothing().when(parqueadero).setTotalMotorbikes(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.numCarsInParking()).thenReturn(valor);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(), Mockito.any(Tiempo.class))).thenReturn(true);
		String resultado = registro.registrarMoto(parqueadero, moto, tiempo);
		
		//Assert
		Assert.assertEquals("No hay cupo", resultado);
	}
	
	@Test
	public void registrarTest2ErroBaseDeDatos() {
		
		//Arrage
		String placa = "EHG441";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(moto.getPlaca()).thenReturn(placa);
		Mockito.when(moto.getCilindraje()).thenReturn((short)125);
		Mockito.when(parqueadero.getTotalMotorbikes()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoMoto()).thenReturn(true);
		Mockito.doNothing().when(parqueadero).setTotalMotorbikes(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.numCarsInParking()).thenReturn(valor);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(true);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.findVehiculo(placa)).thenReturn(vehiculoModel);
		Mockito.when(vehiculoModel.getTipo()).thenReturn("moto");
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(), Mockito.any(Tiempo.class))).thenReturn(true);
		String resultado = registro.registrarMoto(parqueadero, moto, tiempo);
		
		//Assert
		Assert.assertEquals("Error al guardar en la base de datos", resultado);
	}
	
	public void registrarTest2ErroBaseDeDatos2() {
		
		//Arrage
		String placa = "EHG441";
		short[] valor = new short[2];
		valor[0] = 1;
		valor [1] = 1;
		
		//Act
		Mockito.when(moto.getPlaca()).thenReturn(placa);
		Mockito.when(moto.getCilindraje()).thenReturn((short)125);
		Mockito.when(parqueadero.getTotalMotorbikes()).thenReturn((short) 1);
		Mockito.when(parqueadero.hayCupoMoto()).thenReturn(true);
		Mockito.doNothing().when(parqueadero).setTotalMotorbikes(Mockito.anyShort());
		Mockito.when(vehiculoCRUD.numCarsInParking()).thenReturn(valor);
		Mockito.when(vehiculoCRUD.findIntoParking(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.validateVehiculo(Mockito.anyString())).thenReturn(false);
		Mockito.when(vehiculoCRUD.updateVehiculo(Mockito.anyString(), Mockito.any(Tiempo.class))).thenReturn(false);
		Mockito.when(vehiculoCRUD.save(Mockito.anyString(), Mockito.anyString(), Mockito.anyShort(), Mockito.any(Tiempo.class))).thenReturn(false);
		String resultado = registro.registrarMoto(parqueadero, moto, tiempo);
		
		//Assert
		Assert.assertEquals("Error al guardar en la base de datos", resultado);
	}
	
}
