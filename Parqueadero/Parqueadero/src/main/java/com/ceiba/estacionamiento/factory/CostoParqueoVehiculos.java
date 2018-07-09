package com.ceiba.estacionamiento.factory;

import com.ceiba.estacionamiento.productos.CostoParqueoCarro;
import com.ceiba.estacionamiento.productos.CostoParqueoMoto;
import com.ceiba.estacionamiento.productos.CostoParqueoVehiculo;

public class CostoParqueoVehiculos extends CostoParqueoVehiculoFactory{
	
	@Override
	public CostoParqueoVehiculo createProducto(String tipo, short cilindraje) {
		CostoParqueoVehiculo costoParqueoVehiculo = null;
		
		if("carro".equals(tipo)) {
			costoParqueoVehiculo = new CostoParqueoCarro();
		}else if("moto".equals(tipo)) {
				costoParqueoVehiculo = new CostoParqueoMoto(cilindraje);
		}
		return costoParqueoVehiculo;
	}


}
