package com.ceiba.estacionamiento.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.model.TCRMModel;
import com.ceiba.estacionamiento.tcrm.TCRM;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TCRMController {

	private TCRM tCRM = new TCRM(); 
	
	
	private static final String ERROR_AL_OBTENER_EL_TCRM = "Error al obtener el TCRM"; 
	@RequestMapping(value = "/TCRM", method = RequestMethod.GET)
	public TCRMModel tCRMValue() {
		
		try {
			return new TCRMModel(tCRM.getTcrm());
		}catch(Exception e) {
			return new TCRMModel(ERROR_AL_OBTENER_EL_TCRM);
		}
		
	}
}
