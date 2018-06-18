package com.ceiba.Parqueadero.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Estacionamiento {

    @RequestMapping("/")
    public String index() {
        return "Gradle : Hello Spring Boot!";
    }

}