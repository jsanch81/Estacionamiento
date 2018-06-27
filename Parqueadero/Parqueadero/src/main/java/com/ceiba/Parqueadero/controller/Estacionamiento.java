package com.ceiba.Parqueadero.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.Parqueadero.classes.Consulta;
import com.ceiba.Parqueadero.classes.Parqueadero;
import com.ceiba.Parqueadero.classes.Tiempo;
import com.ceiba.Parqueadero.classes.Vigilante;
import com.ceiba.Parqueadero.mensajes.Mensajes;
import com.ceiba.Parqueadero.model.Vehiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Estacionamiento {
	

	
	@Autowired
	private Vigilante vigilante;
		
	@Autowired
	private Consulta consulta;
	private Tiempo tiempo;
	
	private Parqueadero parqueadero;
	
	private Mensajes mensaje;
	
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
    public Mensajes entrada(@RequestBody Map<String,String> map){
    	tiempo = new Tiempo();
        mensaje = new Mensajes(vigilante.registrar(this.parqueadero, map,tiempo));
    	return mensaje;
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
    
    @ResponseBody @RequestMapping(value = "/consulta", method = RequestMethod.POST)
    public Vehiculos consulta(@RequestBody Map<String,String> map) {
    	return consulta.genConsulta(map.get("placa"));
    }
    
    @RequestMapping(value = "/vehiculos", method = RequestMethod.GET)
    public List<Vehiculos> vehiculos(){
    	return consulta.consultarVehiculosEnElParqueadero();
    }

    
    @RequestMapping("/Eje")
    public String ejemplo() {
    	return "ejemplo";
    }
    
    
}