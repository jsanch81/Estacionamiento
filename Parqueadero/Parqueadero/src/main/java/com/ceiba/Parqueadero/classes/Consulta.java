package com.ceiba.parqueadero.classes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.crud.VehiculoCRUD;
import com.ceiba.parqueadero.model.VehiculoModel;
import com.ceiba.parqueadero.model.Vehiculos;

@Service
public class Consulta {

	@Autowired
	private VehiculoCRUD vehiculoCRUD;
		
	/**
	 * 
	 * @param placa
	 * @param tiempo
	 * @return
	 */
	public Vehiculos genConsulta(String placa, Tiempo tiempo) {
		if(!vehiculoCRUD.findIntoParking(placa)) return null;
		VehiculoModel vehiculoModel = vehiculoCRUD.findVehiculo(placa);
		Date ejemplo = vehiculoModel.getFechaIngreso();
		String date = tiempo.dateToString(ejemplo);
		return new Vehiculos(vehiculoModel.getPlaca(),date, vehiculoModel.getTipo());
	}
	
	/**
	 * 
	 * @param tiempo
	 * @return
	 */
	public List<Vehiculos> consultarVehiculosEnElParqueadero(Tiempo tiempo){
		 return vehiculoCRUD.vehiculosIntoParking(tiempo);
	}
	
}
