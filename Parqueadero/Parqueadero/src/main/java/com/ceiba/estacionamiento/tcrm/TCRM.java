package com.ceiba.estacionamiento.tcrm;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.ParseException;

import co.com.sc.nexura.superfinanciera.action.generic.services.trm.action.TCRMServicesInterfaceProxy;
import co.com.sc.nexura.superfinanciera.action.generic.services.trm.action.TcrmResponse;

public class TCRM {
	/**
	 * TCRM query value format
	 */
	private static final  String VALUE_QUERY_FORMAT = "#0.00";

	/**
	 * Web Service end point
	 */
	private static final  String WEB_SERVICE_URL = "https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService?WSDL";

	/**
	 * This method get the TCRM from the page superfinanciera, and return it value.
	 * @return
	 * @throws RemoteException
	 * @throws ParseException
	 */
	public String getTcrm() throws RemoteException, ParseException {
		//
		// Decimal value format declaration
		DecimalFormat decimalFormat = new DecimalFormat(VALUE_QUERY_FORMAT);
		
		TCRMServicesInterfaceProxy proxy = new TCRMServicesInterfaceProxy(WEB_SERVICE_URL);
				
		//
		// Gets the TCRM value for the current date
		TcrmResponse tcrmResponse = proxy.queryTCRM(null);

		return decimalFormat.format(tcrmResponse.getValue());
		
		
	}

}
