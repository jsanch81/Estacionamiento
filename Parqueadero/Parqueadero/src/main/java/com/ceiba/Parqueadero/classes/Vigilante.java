package com.ceiba.Parqueadero.classes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class Vigilante {
	
	@Autowired
	private Registro registro;
	private static String NO_PUEDE_INGRESAR_HOY = "No puede ingresar hoy";
	
	private Tiempo tiempo; 
	
	//para pruebas
	public void setRegistro(Registro registro) {
		this.registro = registro;
	}
	
	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}
	
	
	
	/**
	 * 
	 * @param parqueadero
	 * @param map
	 */
	public String registrar(Parqueadero parqueadero, Map<String , String> map) {
        
		Vehiculo vehiculo;
        tiempo = new Tiempo();
        String placa = map.get("placa");
        String cilindraje = map.get("cilindraje");
        
        if(canPark(placa)) return NO_PUEDE_INGRESAR_HOY;
		
        if(cilindraje.equals("")) {
        	vehiculo = new Carro(placa);
        	return registro.registrar(parqueadero, true, vehiculo);
        }else {
        	short value = Short.parseShort(cilindraje);
        	System.out.println(value);
        	vehiculo = new Moto(placa,value);
        	System.out.println(registro.registrar(parqueadero, false, vehiculo));
        	return registro.registrar(parqueadero, false, vehiculo);
        }
		
	}
	
	
	
	private boolean canPark(String placa) {
		return (placa.toUpperCase().charAt(0)=='A' && (tiempo.getDayWeek() == 1 ||  tiempo.getDayWeek() == 2));
	}
}
