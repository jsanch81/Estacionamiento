package com.ceiba.estacionamiento.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CobroSalidaParqueadero {
	
	
	@Autowired
	private SalidaParqueadero salida;
	
	private CostoTotal costoTotal = new CostoTotal();

	/**
	 * this method will make the payment to the cars or motorbikes which will go out of the parking,
	 * it will return -1 when there are some error in the moment that it make the payment.
	 * @param placa
	 * @param tiempo
	 * @param parqueadero
	 * @return
	 */
	public int generarCobro(String placa, Tiempo tiempo) {
		
		long ingreso = salida.generarSalida(placa);
		if(ingreso==-1){
			return -1;
		}
		
		String tipo = salida.tipoVehiculo(placa);
		short cilindraje = salida.getCilindraje(placa);
		
		return costoTotal.generarCosto(tipo, ingreso, tiempo.getTimestamp(), tiempo, cilindraje);
		
	}
	

}
