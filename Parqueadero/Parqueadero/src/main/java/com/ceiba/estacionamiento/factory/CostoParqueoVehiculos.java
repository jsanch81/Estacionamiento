package com.ceiba.estacionamiento.factory;

import com.ceiba.estacionamiento.productos.CostoParqueoCarro;
import com.ceiba.estacionamiento.productos.CostoParqueoMoto;
import com.ceiba.estacionamiento.productos.CostoParqueoMotoAltoCilindraje;
import com.ceiba.estacionamiento.productos.CostoParqueoVehiculo;

public class CostoParqueoVehiculos extends CostoParqueoVehiculoFactory{

	private static final int ALTO_CILINDRAJE = 500;
	
	@Override
	public CostoParqueoVehiculo createProducto(String tipo, short cilindraje) {
		CostoParqueoVehiculo costoParqueoVehiculo = null;
		
		if("carro".equals(tipo)) {
			costoParqueoVehiculo = new CostoParqueoCarro();
		}else if("moto".equals(tipo)) {
			if(cilindraje>ALTO_CILINDRAJE) {
				costoParqueoVehiculo = new CostoParqueoMotoAltoCilindraje();
			}else {
				costoParqueoVehiculo = new CostoParqueoMoto();
			}
		}
		return costoParqueoVehiculo;
	}


}
