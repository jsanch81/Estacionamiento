package com.ceiba.Parqueadero.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class CobroSalidaParqueadero {
	
	
	@Autowired
	private SalidaParqueadero salida;
	
	private final int valorHoraCarro = 1000;
	private final int valorDiaCarro = 8000;
	private final int valorHoraMoto = 500;
	private final int valotDiaMoto = 4000;
	private final int MotosAltoCilindraje = 2000;
	private final String carro = "carro";
	/**
	 * 
	 * @param placa
	 * @param tiempo
	 * @return
	 */
	
	
	public int generarCobro(String placa, Tiempo tiempo, Parqueadero parqueadero) {
		long ingreso = salida.generarSalida(placa, parqueadero);
		if(ingreso==-1) return -1;
		String tipo = salida.tipoVehiculo(placa);
		short cilindraje = salida.getCilindraje(placa);
		
		int[] dayHoursMils = new int[3];
		dayHoursMils = tiempo.calculateDaysHoursMils(ingreso, tiempo.getTimestamp());
		int total;
		if(tipo.equals(carro)) {
			total = dayHoursMils[0]*valorDiaCarro;
			total += (dayHoursMils[1]<9)?dayHoursMils[1]*valorHoraCarro:valorDiaCarro;
			total += (dayHoursMils[2]>0)?valorHoraCarro:0;
		}else {
			total = dayHoursMils[0]*valotDiaMoto;
			total += (dayHoursMils[1]<9)?dayHoursMils[1]*valorHoraMoto:valotDiaMoto;
			total += (dayHoursMils[2]>0)?valorHoraMoto:0;
			total += (cilindraje>valorHoraMoto)?MotosAltoCilindraje:0;
		}
		
		return total;
	}
	
	public void setSalida(SalidaParqueadero salida) {
		this.salida = salida;
	}

}