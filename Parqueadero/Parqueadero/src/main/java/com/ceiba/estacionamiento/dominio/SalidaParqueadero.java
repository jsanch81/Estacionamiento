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
	 * 
	 * @param placa
	 * @param parqueadero
	 * @return
	 */
	public long generarSalida(String placa) {
		
		long valorValidacionesSalida = validaciones.validarSalidaVehiculo(placa); 
		if(valorValidacionesSalida!=0) {
			return valorValidacionesSalida;
		}
		
		return vehiculoCRUD.findVehiculo(placa).getIngresoTimestamp();
	}
	
	/**
	 * 
	 * @param placa
	 * @return
	 */
	public String tipoVehiculo(String placa) {
		return vehiculoCRUD.findVehiculo(placa).getTipo();
	}
	/**
	 * 
	 * @param placa
	 * @return
	 */
	public short getCilindraje(String placa) {
		return vehiculoCRUD.findVehiculo(placa).getCilindraje();
	}

}
