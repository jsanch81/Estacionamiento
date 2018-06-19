package com.ceiba.Parqueadero.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceiba.Parqueadero.classes.*;

@RestController
public class Estacionamiento {
	/**
	 * 
	 */
	private Parqueadero parqueadero = new Parqueadero();
	private Vigilante vigilante = new Vigilante("jose","123");
    
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Gradle : Hello Spring Boot!";
    }
    
    
    /**
     * 
     * @param map Objects of body that receive from a post
     * @return status
     */
    @ResponseBody @RequestMapping("/description")
    public String getDescription(@RequestBody Map<String,String> map){
        System.out.println(map.get("cilindraje"));
        vigilante.registrar(this.parqueadero, map);
    	return "200";
    }

    
}