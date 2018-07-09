package com.ceiba.estacionamiento;

import java.rmi.RemoteException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author jose.sanchez
 *
 */
@SpringBootApplication
public class ParqueaderoApplication {

	public static void main(String[] args) throws RemoteException, ParseException {
		
		SpringApplication.run(ParqueaderoApplication.class, args);
	}
}
