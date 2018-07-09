package com.ceiba.estacionamiento.factory;

import com.ceiba.estacionamiento.productos.CostoParqueoVehiculo;

public abstract class CostoParqueoVehiculoFactory {
	public abstract CostoParqueoVehiculo createProducto(String tipo, short cilindrage);
}
