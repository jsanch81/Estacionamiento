package com.ceiba.Parqueadero.crud;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.Parqueadero.model.VehiculoModel;
import com.ceiba.Parqueadero.repository.ParqueaderoRepository;

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
	
	public void testSave() {
		//Arrange
		String placa = "EHG44B";
		String tipo = "carro";
		short cilindraje = 125;
		
		
	}
	
}
