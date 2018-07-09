package com.ceiba.estacionamiento.dominio;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Vigilante {
	
	@Autowired
	private Registro registro;
	
	@Autowired
	private CobroSalidaParqueadero cobrar;
	
	private FabricaVehiculos fabricaVehiculos = new FabricaVehiculos();
	
	private static final String NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL = "no puede ingresar porque no esta en un dia habil";
	private static final String DEBE_DE_INGRESAR_MINIMO_LA_PLACA = "Debe de ingresar minimo la placa";	
	
	
	
	
	/**
	 * 
	 * @param parqueadero
	 * @param map
	 */
	public String realizarRegistro(Parqueadero parqueadero, Map<String , String> map, Tiempo tiempo) {
		String placa = map.get("placa");
		
		if(placa == null || "".equals(placa)) {
			return DEBE_DE_INGRESAR_MINIMO_LA_PLACA;
		}
		
        placa = placa.toUpperCase();
        
        String tipo = map.get("tipo");
        String cilindraje = map.get("cilindraje");
        
        if(noPuedeParquear(placa,tiempo)) {
        	return NO_PUEDE_INGRESAR_PORQUE_NO_ESTA_EN_UN_DIA_HABIL;
        }
        
        Vehiculo vehiculo = fabricaVehiculos.crearVehiculo(cilindraje, placa, tipo);
		
        return registro.registrarVehiculo(parqueadero, vehiculo, tiempo);
	}
	
	public int realizarCobro(Map<String , String> map, Tiempo tiempo) {
		String placa = map.get("placa");
		return cobrar.generarCobro(placa, tiempo);
	}

	
	private boolean noPuedeParquear(String placa, Tiempo tiempo) {
		return (placa.toUpperCase().charAt(0)=='A' && tiempo.getDiaSemana() != 1 &&  tiempo.getDiaSemana() != 2);
	}
}
