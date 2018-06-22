package com.ceiba.Parqueadero.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class Cobrar {
	
	@Autowired
	private Salida salida;
	
	/**
	 * 
	 * @param placa
	 * @param tiempo
	 * @return
	 */
	public int genCobro(String placa, Tiempo tiempo, Parqueadero parqueadero) {
		long ingreso = salida.genSalida(placa, parqueadero);
		if(ingreso==-1) return -1;
		String tipo = salida.tipoVehiculo(placa);
		short cilindraje = salida.getCilindraje(placa);
		
		int[] dayHoursMils = new int[3];
		dayHoursMils = tiempo.calculateDaysHoursMils(ingreso, tiempo.getTimestamp());
		int total;
		if(tipo.equals("carro")) {
			total = dayHoursMils[0]*8000;
			total += (dayHoursMils[1]<9)?dayHoursMils[1]*1000:8000;
			total += (dayHoursMils[2]>0)?1000:0;
		}else {
			total = dayHoursMils[0]*4000;
			total += (dayHoursMils[1]<9)?dayHoursMils[1]*500:4000;
			total += (dayHoursMils[2]>0)?500:0;
			total += (cilindraje>500)?2000:0;
		}
		
		return total;
	}
	
	public void setSalida(Salida salida) {
		this.salida = salida;
	}

}
