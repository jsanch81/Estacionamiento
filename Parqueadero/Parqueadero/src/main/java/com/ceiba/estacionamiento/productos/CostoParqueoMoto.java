package com.ceiba.estacionamiento.productos;

public class CostoParqueoMoto extends CostoParqueoVehiculo{
	public CostoParqueoMoto(short cilindraje) {
		if(cilindraje>500) {
			setCostoDia(4000);
			setCostoHora(500);
			setCostoExtra(2000);
		}else {
			setCostoDia(4000);
			setCostoHora(500);
			setCostoExtra(0);
		}
	}
}
