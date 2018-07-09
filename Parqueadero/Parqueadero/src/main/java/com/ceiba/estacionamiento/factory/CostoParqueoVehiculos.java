package com.ceiba.estacionamiento.factory;

import com.ceiba.estacionamiento.productos.PrecioParqueoCarro;
import com.ceiba.estacionamiento.productos.PrecioParqueoMoto;
import com.ceiba.estacionamiento.productos.PrecioParqueoVehiculo;

public class CostoParqueoVehiculos extends CostoParqueoVehiculoFactory{
	
	@Override
	public PrecioParqueoVehiculo createProducto(String tipo, short cilindraje) {
		PrecioParqueoVehiculo costoParqueoVehiculo = null;
		
		if("carro".equals(tipo)) {
			costoParqueoVehiculo = new PrecioParqueoCarro();
		}else if("moto".equals(tipo)) {
				costoParqueoVehiculo = new PrecioParqueoMoto(cilindraje);
		}
		return costoParqueoVehiculo;
	}


}
