package com.ceiba.estacionamiento.factory;

import com.ceiba.estacionamiento.productos.PrecioParqueoVehiculo;

public abstract class CostoParqueoVehiculoFactory {
	public abstract PrecioParqueoVehiculo createProducto(String tipo, short cilindrage);
}
