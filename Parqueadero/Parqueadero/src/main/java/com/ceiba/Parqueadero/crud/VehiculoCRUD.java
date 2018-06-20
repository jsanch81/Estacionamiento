package com.ceiba.Parqueadero.crud;

import com.ceiba.Parqueadero.model.VehiculoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.ceiba.Parqueadero.classes.Tiempo;

import com.ceiba.Parqueadero.repository.ParqueaderoRepository;

@Service
@Configurable
public class VehiculoCRUD {
	
	@Autowired
	private ParqueaderoRepository parqueaderoRepository;
	
	private VehiculoModel vehiculoModel;
	private Tiempo tiempo = new Tiempo();


	
	public boolean save(String placa, String tipo, short cilindraje) {
		vehiculoModel = new VehiculoModel(placa, tipo, cilindraje);
		vehiculoModel.setFechaIngreso(tiempo.getDate());
		vehiculoModel.setEstado("true");
		vehiculoModel.setIngresoTimestamp(tiempo.getTimestamp());
		try {
			parqueaderoRepository.save(vehiculoModel);
			return true;
		}catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
}
