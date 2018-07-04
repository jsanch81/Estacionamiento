package com.ceiba.parqueadero.TRMC;
import org.junit.Test;

import com.ceiba.parqueadero.tcrm.TCRM;

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
