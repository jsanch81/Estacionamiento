package com.ceiba.estacionamiento.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.crud.VehiculoCRUD;

@Service
public class Registro {
	
	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	@Autowired
	private Validaciones validaciones;
	
	@Autowired
	private ActualizarVehiculo actualizarVehiculo;
	
	private static final String REGISTRO_REALIZADO = "Registro realizado";

	
	/**
	 * 
	 * @param parqueadero
	 * @param vehiculo
	 * @param tiempo
	 * @return
	 */
	public String registrarVehiculo(Parqueadero parqueadero, Vehiculo vehiculo, Tiempo tiempo) {
		String placa = vehiculo.getPlaca();
		String tipo = vehiculo.getTipoVehiculo();
		
		String resultadoValidacionVehiculo = validaciones.validarVehiculosEnParqueadero(placa, parqueadero, tipo);
		if(resultadoValidacionVehiculo!=null) {
			return resultadoValidacionVehiculo;
		}
		
		String mensajeActulizarVehiculo = actualizarVehiculo.actualizar(placa, tipo, tiempo);
		
		if(mensajeActulizarVehiculo!=null) {
			return mensajeActulizarVehiculo;
		}
		
		vehiculoCRUD.save(placa, vehiculo.getTipoVehiculo(),  vehiculo.getCilindraje(), tiempo);
		
		return REGISTRO_REALIZADO;
	}
	
}
