package com.ceiba.estacionamiento.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.crud.VehiculoCRUD;

@Service
public class SalidaParqueadero {

	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	@Autowired
	private Validaciones validaciones;
		
	/**
	 * this method is responsible to update the state of the vehicle in the data base in false and get the timestamp of entry, 
	 * but it validate if the vehicle is into the parking.
	 * @param placa
	 * @param parqueadero
	 * @return
	 */
	public long generarSalida(String placa) {
		long valorValidacionesSalida = validaciones.validarSalidaVehiculo(placa); 
		if(valorValidacionesSalida!=0) {
			return valorValidacionesSalida;
		}
		
		return vehiculoCRUD.buscarVehiculo(placa).getIngresoTimestamp();
	}
	
	/**
	 * This method get the type of vehicle by its placa in the data base
	 * @param placa
	 * @return
	 */
	public String tipoVehiculo(String placa) {
		return vehiculoCRUD.buscarVehiculo(placa).getTipo();
	}
	
	/**
	 * This method get the displacement of the vehicle by its placa in teh data base.
	 * @param placa
	 * @return
	 */
	public short getCilindraje(String placa) {
		return vehiculoCRUD.buscarVehiculo(placa).getCilindraje();
	}

}
