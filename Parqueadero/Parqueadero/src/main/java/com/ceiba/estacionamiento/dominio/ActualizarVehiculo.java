package com.ceiba.estacionamiento.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.crud.VehiculoCRUD;

@Service
public class ActualizarVehiculo {
	
	@Autowired
	private VehiculoCRUD vehiculoCRUD;
	
	@Autowired
	private Validaciones validaciones;
	
	private static final String ESTE_VEHICULO_YA_SE_REGISTRO_COMO_UN_TIPO_DIFERENTE = "Este vehiculo ya se registro como otro tipo de vehiculos";
	private static final String REGISTRO_REALIZADO = "Registro realizado";

	public String actualizar(String placa, String tipo, Tiempo tiempo) {
		
		if(validaciones.validarVehiculosIngresadosAntes(placa)) {
			if(!validaciones.validarVehiculosYaRegistrados(placa, tipo)) {
				return ESTE_VEHICULO_YA_SE_REGISTRO_COMO_UN_TIPO_DIFERENTE;
			}
			vehiculoCRUD.updateVehiculo(placa, tiempo);
			return REGISTRO_REALIZADO;
		}
		return null;
	}
}
