package com.ceiba.parqueadero;

import java.rmi.RemoteException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ParqueaderoApplication {

	public static void main(String[] args) throws RemoteException, ParseException {
		
		SpringApplication.run(ParqueaderoApplication.class, args);
	}
}
