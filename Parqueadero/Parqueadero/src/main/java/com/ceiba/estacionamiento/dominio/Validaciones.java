package com.ceiba.estacionamiento.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.crud.VehiculoCRUD;

@Service
public class Validaciones {
	
	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	private static final String NO_HAY_CUPO = "No hay cupo";
	private static final String EL_VEHICULO_YA_INGRESO = "El vehiculo ya ingreso";


	public String validarVehiculosParqueados(String placa, Parqueadero parqueadero, String tipo) {
		if(!parqueadero.hayCupoVehiulo(vehiculoCRUD.numCarsInParking(), tipo)) {
			return NO_HAY_CUPO;
		}
		if(vehiculoCRUD.vehiculoRegistrado(placa)&&vehiculoCRUD.vehiculoParqueado(placa)) {
			return EL_VEHICULO_YA_INGRESO;
		}
		return null;
	}
	
	public boolean validarVehiculosRegistradosPorTipo(String placa, String tipo) {
		return tipo.equals(vehiculoCRUD.buscarVehiculo(placa).getTipo());
	}
	
	public boolean validarVehiculosRegistradosNoParqueados(String placa) {
		return vehiculoCRUD.vehiculoRegistrado(placa)&&!vehiculoCRUD.vehiculoParqueado(placa); 
	}
	
	
	public long validarSalidaVehiculo(String placa) {
		
		if(!vehiculoCRUD.vehiculoRegistrado(placa)||!vehiculoCRUD.vehiculoParqueado(placa)) {
			return -1;
		}

		
		if(!vehiculoCRUD.updateSalidaVehiculo(placa)) {
			return -2;
		}
	
		return 0;
	}
}
