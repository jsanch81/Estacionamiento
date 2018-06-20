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
	
	
	/**
	 * 
	 * @param parqueadero
	 * @param map
	 */
	public String registrar(Parqueadero parqueadero, Map<String , String> map) {
        
		Vehiculo vehiculo;
        Tiempo tiempo = new Tiempo();
        String placa = map.get("placa");
        String cilindraje = map.get("cilindraje");
        
        if(tiempo.canPark(placa)) return NO_PUEDE_INGRESAR_HOY;
		
        if(cilindraje.equals("")) {
        	vehiculo = new Carro(placa);
        	return registro.registrar(parqueadero, true, vehiculo);
        }else {
        	short value = Short.parseShort(cilindraje);
        	vehiculo = new Moto(placa,value);
        	return registro.registrar(parqueadero, false, vehiculo);
        }
		
	}
}
