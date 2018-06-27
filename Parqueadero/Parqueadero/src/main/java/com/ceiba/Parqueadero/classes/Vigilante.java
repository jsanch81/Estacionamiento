package com.ceiba.Parqueadero.classes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Vigilante {
	
	@Autowired
	private Registro registro;
	
	@Autowired
	private CobroSalidaParqueadero cobrar;
	
	@Autowired
	
	private static String NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL = "no puede ingresar porque no está en un dia hábil";
		

	
	
	
	/**
	 * 
	 * @param parqueadero
	 * @param map
	 */
	public String registrar(Parqueadero parqueadero, Map<String , String> map, Tiempo tiempo) {
        
        String placa = map.get("placa").toUpperCase();
        String cilindraje = map.get("cilindraje").toUpperCase();
        
        if(canPark(placa,tiempo)) return NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL;
		
        if(cilindraje == null || cilindraje.equals("")) {
        	return registro.registrarCarro(parqueadero, new Carro(placa), tiempo);
        }else {
        	short value = Short.parseShort(cilindraje);
        	return registro.registrarMoto(parqueadero, new Moto(placa,value), tiempo);
        }
		
	}
	
	public int cobrar(Parqueadero parqueadero, Map<String , String> map, Tiempo tiempo) {
		String placa = map.get("placa");
		return cobrar.generarCobro(placa, tiempo, parqueadero);
	}

	
	private boolean canPark(String placa, Tiempo tiempo) {
		return (placa.toUpperCase().charAt(0)=='A' && tiempo.getDayWeek() != 1 &&  tiempo.getDayWeek() != 2);
	}
}
