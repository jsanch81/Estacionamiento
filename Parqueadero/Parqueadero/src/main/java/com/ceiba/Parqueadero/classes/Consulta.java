package com.ceiba.Parqueadero.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.model.VehiculoModel;
import com.ceiba.Parqueadero.model.Vehiculos;

@Service
public class Consulta {

	@Autowired
	private VehiculoCRUD vehiculoCRUD;
		
	
	public Vehiculos genConsulta(String placa) {
		if(!vehiculoCRUD.findIntoParking(placa)) return null;
		VehiculoModel vehiculoModel = vehiculoCRUD.findVehiculo(placa);
		return new Vehiculos(vehiculoModel.getPlaca(), vehiculoModel.getFechaIngreso(), vehiculoModel.getTipo());
	}
	
	public List<Vehiculos> consultarVehiculosEnElParqueadero(){
		 return vehiculoCRUD.vehiculosIntoParking();
	}
	
}
