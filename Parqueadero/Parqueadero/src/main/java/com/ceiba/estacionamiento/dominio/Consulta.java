package com.ceiba.estacionamiento.dominio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.crud.VehiculoCRUD;
import com.ceiba.estacionamiento.modelos.VehiculoModel;
import com.ceiba.estacionamiento.modelos.Vehiculos;

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
	public Vehiculos generarConsulta(String placa, Tiempo tiempo) {
		if(!vehiculoCRUD.vehiculoRegistrado(placa)) { 
			return null;
		}
		
		VehiculoModel vehiculoModel = vehiculoCRUD.buscarVehiculo(placa);
		Date ejemplo = vehiculoModel.getFechaIngreso();
		String date = tiempo.dateToString(ejemplo);
		return new Vehiculos(vehiculoModel.getPlaca(),date, vehiculoModel.getTipo());
	}
	
	/**
	 * 
	 * @param tiempo
	 * @return
	 */
	public List<Vehiculos> consultarVehiculosParqueados(Tiempo tiempo){
		 return vehiculoCRUD.vehiculosIntoParking(tiempo);
	}
	
}
