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
	private static String NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL = "no puede ingresar porque no está en un dia hábil";
	
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
	public String registrar(Parqueadero parqueadero, Map<String , String> map, Tiempo tiempo) {
        
        String placa = map.get("placa");
        String cilindraje = map.get("cilindraje");
        
        if(canPark(placa)) return NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL;
		
        if(cilindraje.equals("")) {
        	return registro.registrarCarro(parqueadero, new Carro(placa));
        }else {
        	short value = Short.parseShort(cilindraje);
        	return registro.registrarMoto(parqueadero, new Moto(placa,value));
        }
		
	}
	
	
	
	private boolean canPark(String placa) {
		return (placa.toUpperCase().charAt(0)=='A' && tiempo.getDayWeek() != 1 &&  tiempo.getDayWeek() != 2);
	}
}
