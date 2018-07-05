package com.ceiba.estacionamiento.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CobroSalidaParqueadero {
	
	
	@Autowired
	private SalidaParqueadero salida;
	
	private static final int VALOR_HORA_CARRO = 1000;
	private static final int VALOR_DIA_CARRO = 8000;
	private static final int VALOR_HORA_MOTO = 500;
	private static final int VALOR_DIA_MOTO = 4000;
	private static final int MOTOS_ALTO_CILINDRAJE = 2000;
	private static final String CARRO = "carro";
	/**
	 * 
	 * @param placa
	 * @param tiempo
	 * @return
	 */
	
	
	public int generarCobro(String placa, Tiempo tiempo, Parqueadero parqueadero) {
		long ingreso = salida.generarSalida(placa, parqueadero);
		
		if(ingreso==-1){
			return -1;
		}
		
		String tipo = salida.tipoVehiculo(placa);
		short cilindraje = salida.getCilindraje(placa);
		
		int[] dayHoursMils = tiempo.calculateDaysHoursMils(ingreso, tiempo.getTimestamp());
		int total;
		
		
		if(tipo.equals(CARRO)) {
			total = dayHoursMils[0]*VALOR_DIA_CARRO;
			total += (dayHoursMils[1]<9)?dayHoursMils[1]*VALOR_HORA_CARRO:VALOR_DIA_CARRO;
			total += (dayHoursMils[2]>0)?VALOR_HORA_CARRO:0;
		}else {
			total = dayHoursMils[0]*VALOR_DIA_MOTO;
			total += (dayHoursMils[1]<9)?dayHoursMils[1]*VALOR_HORA_MOTO:VALOR_DIA_MOTO;
			total += (dayHoursMils[2]>0)?VALOR_HORA_MOTO:0;
			total += (cilindraje>VALOR_HORA_MOTO)?MOTOS_ALTO_CILINDRAJE:0;
		}
		
		return total;
	}
	

}
