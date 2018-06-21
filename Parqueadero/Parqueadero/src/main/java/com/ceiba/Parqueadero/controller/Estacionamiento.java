package com.ceiba.Parqueadero.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceiba.Parqueadero.classes.Vigilante;
import com.ceiba.Parqueadero.crud.VehiculoCRUD;
import com.ceiba.Parqueadero.classes.Parqueadero;

@Controller
public class Estacionamiento {
	
	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	@Autowired
	private Vigilante vigilante;
	
	
	
	private Parqueadero parqueadero = new Parqueadero();

	
    
    /**
     * 
     * @param map Objects of body that receive from a post
     * @return status
     */
    @ResponseBody @RequestMapping(value = "/description", method = RequestMethod.POST)
    public String getDescription(@RequestBody Map<String,String> map){
        return vigilante.registrar(this.parqueadero, map);
    }

    
}