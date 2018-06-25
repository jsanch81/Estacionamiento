package com.ceiba.Parqueadero.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.model.VehiculoModel;

@Service
@Configurable
public class Consulta {

	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	private VehiculoModel vehiculoModel;
	private Tiempo tiempo= new Tiempo();
	
	private static final String EL_VEHICULO_NO_ESTA_EN_LA_BASE_DE_DATOS = "El vihiculo no esta en la base de datos";
	
	
	public String genConsulta(String placa) {
		if(!vehiculoCRUD.findIntoParking(placa)) return EL_VEHICULO_NO_ESTA_EN_LA_BASE_DE_DATOS;
		vehiculoModel = vehiculoCRUD.findVehiculo(placa);
		String date = tiempo.dateToString(vehiculoModel.getFechaIngreso());
		return " Placa: "+vehiculoModel.getPlaca()+"\n Tipo Vehiculo: "+vehiculoModel.getTipo()+"\n Fecha ingreso: "+ date;
	}
	
	//Para Test
	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}
	
	public void setVehiculoModel(VehiculoModel vehiculoModel) {
		this.vehiculoModel = vehiculoModel;
	}
	
	public void setVehiculoCRUD(VehiculoCRUD vehiculoCRUD) {
		this.vehiculoCRUD = vehiculoCRUD;
	}
}
