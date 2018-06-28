package com.ceiba.Parqueadero.classes;

import java.util.Date;
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
		
	
	public Vehiculos genConsulta(String placa, Tiempo tiempo) {
		if(!vehiculoCRUD.findIntoParking(placa)) return null;
		VehiculoModel vehiculoModel = vehiculoCRUD.findVehiculo(placa);
		Date ejemplo = vehiculoModel.getFechaIngreso();
		String date = tiempo.dateToString(ejemplo);
		return new Vehiculos(vehiculoModel.getPlaca(),date, vehiculoModel.getTipo());
	}
	
	public List<Vehiculos> consultarVehiculosEnElParqueadero(Tiempo tiempo){
		 return vehiculoCRUD.vehiculosIntoParking(tiempo);
	}
	
}
