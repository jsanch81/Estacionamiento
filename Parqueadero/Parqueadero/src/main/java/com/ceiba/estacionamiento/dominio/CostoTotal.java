package com.ceiba.estacionamiento.dominio;


import com.ceiba.estacionamiento.factory.CostoParqueoVehiculoFactory;
import com.ceiba.estacionamiento.factory.CostoParqueoVehiculos;
import com.ceiba.estacionamiento.modelos.TiempoParqueado;
import com.ceiba.estacionamiento.productos.PrecioParqueoVehiculo;

public class CostoTotal {

	private CostoParqueoVehiculoFactory costoFactory =  new CostoParqueoVehiculos();
	private TiempoParqueado tiempoParqueado;
	private static final  int HORA_INICIO_DIA = 9;
	
	
	/**
	 * this method make the calculations of the total cost that the client has to pay. it calculates
	 * this cost depending of time and the price which depends of the type vehicle.
	 * @param tipo
	 * @param fechaIngreso
	 * @param fechaSalida
	 * @param tiempo
	 * @param cilindraje
	 * @return
	 */
	public int generarCosto(String tipo, long fechaIngreso, long fechaSalida, Tiempo tiempo, short cilindraje) {
	
		tiempoParqueado = tiempo.calcularDiasHorasMils(fechaIngreso, fechaSalida);
		PrecioParqueoVehiculo costoProducto = costoFactory.createProducto(tipo, cilindraje);
		
		int costoVehiculoDia = costoProducto.getCostoDia();
		int costoVehiculoHora = costoProducto.getCostoHora();
		int costoVehiculoExtra = costoProducto.getCostoExtra();
		int total = 0;
		
		total = tiempoParqueado.getDias()*costoVehiculoDia;
		total += (tiempoParqueado.getHoras()<HORA_INICIO_DIA)?tiempoParqueado.getHoras()*costoVehiculoHora:costoVehiculoHora;
		total += (tiempoParqueado.getMilis()>0)?costoVehiculoHora:0;
		total += costoVehiculoExtra;
		return total;
	}
}
