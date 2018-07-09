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

	/**
	 * This method checks the quota of the parking and it validates 
	 * if the vehicle with a respective placa is or isn't into the parking
	 * @param placa
	 * @param parqueadero
	 * @param tipo
	 * @return
	 */
	public String validarVehiculosParqueados(String placa, Parqueadero parqueadero, String tipo) {
		if(!parqueadero.hayCupoVehiulo(vehiculoCRUD.numCarsInParking(), tipo)) {
			return NO_HAY_CUPO;
		}
		if(vehiculoCRUD.vehiculoRegistrado(placa)&&vehiculoCRUD.vehiculoParqueado(placa)) {
			return EL_VEHICULO_YA_INGRESO;
		}
		return null;
	}
	
	/**
	 * It validates if the vehicle that will register has been into the parking, 
	 * and check if it will register with the same type.
	 * @param placa
	 * @param tipo
	 * @return
	 */
	public boolean validarVehiculosRegistradosPorTipo(String placa, String tipo) {
		return tipo.equals(vehiculoCRUD.buscarVehiculo(placa).getTipo());
	}
	
	/**
	 * this method validate if the vehicle has been into the parking but in this moment isn't into.
	 * @param placa
	 * @return
	 */
	public boolean validarVehiculosRegistradosNoParqueados(String placa) {
		return vehiculoCRUD.vehiculoRegistrado(placa)&&!vehiculoCRUD.vehiculoParqueado(placa); 
	}
	
	/**
	 * this method validates first if the vehicle is into parking, after that it update the state of vehicle in teh data base.
	 * @param placa
	 * @return
	 */
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
