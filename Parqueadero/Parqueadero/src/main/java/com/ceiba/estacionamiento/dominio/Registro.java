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
	 * This method make the registrations of vehicles, but it make too some validations 
	 * to see if there are quota into the parking
	 * @param parqueadero
	 * @param vehiculo
	 * @param tiempo
	 * @return
	 */
	public String registrarVehiculo(Parqueadero parqueadero, Vehiculo vehiculo, Tiempo tiempo) {
		String placa = vehiculo.getPlaca();
		String tipo = vehiculo.getTipoVehiculo();
		
		String resultadoValidacionVehiculo = validaciones.validarVehiculosParqueados(placa, parqueadero, tipo);
		if(resultadoValidacionVehiculo!=null) {
			return resultadoValidacionVehiculo;
		}
		
		String mensajeActulizarVehiculo = actualizarVehiculo.actualizar(placa, tipo, tiempo);
		
		if(mensajeActulizarVehiculo!=null) {
			return mensajeActulizarVehiculo;
		}
		
		vehiculoCRUD.guardar(placa, vehiculo.getTipoVehiculo(),  vehiculo.getCilindraje(), tiempo);
		
		return REGISTRO_REALIZADO;
	}
	
}
