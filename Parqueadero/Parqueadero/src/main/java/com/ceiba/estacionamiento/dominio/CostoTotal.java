package com.ceiba.estacionamiento.dominio;


import com.ceiba.estacionamiento.factory.CostoParqueoVehiculoFactory;
import com.ceiba.estacionamiento.factory.CostoParqueoVehiculos;
import com.ceiba.estacionamiento.modelos.TiempoParqueado;
import com.ceiba.estacionamiento.productos.PrecioParqueoVehiculo;

public class CostoTotal {

	private CostoParqueoVehiculoFactory costoFactory =  new CostoParqueoVehiculos();
	private TiempoParqueado tiempoParqeuado;
	private static final  int HORA_INICIO_DIA = 9;
	
	public int generarCosto(String tipo, long fechaIngreso, long fechaSalida, Tiempo tiempo, short cilindraje) {
	
		tiempoParqeuado = tiempo.calcularDiasHorasMils(fechaIngreso, fechaSalida);
		PrecioParqueoVehiculo costoProducto = costoFactory.createProducto(tipo, cilindraje);
		
		int costoVehiculoDia = costoProducto.getCostoDia();
		int costoVehiculoHora = costoProducto.getCostoHora();
		int costoVehiculoExtra = costoProducto.getCostoExtra();
		int total = 0;
		
		total = tiempoParqeuado.getDias()*costoVehiculoDia;
		total += (tiempoParqeuado.getHoras()<HORA_INICIO_DIA)?tiempoParqeuado.getHoras()*costoVehiculoHora:costoVehiculoHora;
		total += (tiempoParqeuado.getMilis()>0)?costoVehiculoHora:0;
		total += costoVehiculoExtra;
		return total;
	}
}
