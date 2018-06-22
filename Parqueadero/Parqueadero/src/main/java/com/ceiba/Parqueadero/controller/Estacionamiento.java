package com.ceiba.Parqueadero.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ceiba.Parqueadero.classes.Vigilante;
import com.ceiba.Parqueadero.classes.Parqueadero;
import com.ceiba.Parqueadero.classes.Tiempo;

@Controller
public class Estacionamiento {
	

	
	@Autowired
	private Vigilante vigilante;
	
	private Tiempo tiempo;
	
	private Parqueadero parqueadero;
	
	private static final String EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO = "El vehiculo no esta en el parqueadero"; 
	private static final String ERROR_AL_GENERAR_LA_SALIDA_EN_LA_BASE_DE_DATOS = "Error al generar la salida de la base de datos";
	
	public Estacionamiento() {
		parqueadero = new Parqueadero();
	}	
	
    
    /**
     * 
     * @param map Objects of body that receive from a post
     * @return status
     */
    @ResponseBody @RequestMapping(value = "/entrada", method = RequestMethod.POST)
    public String entrada(@RequestBody Map<String,String> map){
    	tiempo = new Tiempo();
        return vigilante.registrar(this.parqueadero, map,tiempo);
    }
    
    @ResponseBody @RequestMapping(value = "/salida", method = RequestMethod.POST)
    public String salida(@RequestBody Map<String,String> map) {
    	tiempo = new Tiempo();
    	int resultado = vigilante.cobrar(parqueadero, map, tiempo);
    	if(resultado == -1) {
    		return EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO;
    	}else if(resultado == -2) {
    		return ERROR_AL_GENERAR_LA_SALIDA_EN_LA_BASE_DE_DATOS;
    	}else {
    		return Integer.toString(resultado);
    	}
    }
    
}