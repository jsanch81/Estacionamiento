package com.ceiba.Parqueadero.classes;

import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.testdatabuilder.VehiculoTestDataBuilder;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import org.junit.Before;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VigilanteTest {

	@Autowired
	private Vigilante vigilante;
	@Mock
	private Registro registro;
	
	
	private Vehiculo vehiculo;
	
	
	
	@Before
	public void setup() {
		
		vehiculo = new VehiculoTestDataBuilder().withcilindraje((short)125).buildMoto();
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
		Mockito.when(registro.registrar(Mockito.any(Parqueadero.class), Mockito.anyBoolean(), Mockito.any(Vehiculo.class))).thenReturn("Registro realizado");
				
		String resultado = vigilante.registrar(new Parqueadero(), map);
		System.out.println(resultado);
		//Assert
		
		Assert.assertEquals("Registro realizado", resultado);
	}
	
	
}
