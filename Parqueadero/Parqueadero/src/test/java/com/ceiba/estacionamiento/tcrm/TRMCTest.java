package com.ceiba.estacionamiento.tcrm;
import org.junit.Test;

import com.ceiba.estacionamiento.tcrm.TCRM;

import org.junit.Assert;


public class TRMCTest {
	
	private TCRM tMRC = new TCRM();
	
	@Test
	public void TRMCtest() {
			
		String resultado = "";
		try {
			resultado = tMRC.getTRMC();

		}catch(Exception e) {
			resultado = "ERROR";
		}
		System.out.println(resultado);
		Assert.assertNotEquals("ERROR", resultado);
	}
}
