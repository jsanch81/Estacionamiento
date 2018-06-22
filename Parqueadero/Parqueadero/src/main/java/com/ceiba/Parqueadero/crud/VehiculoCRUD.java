package com.ceiba.Parqueadero.crud;

import com.ceiba.Parqueadero.model.VehiculoModel;
import com.ceiba.Parqueadero.repository.ParqueaderoRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.ceiba.Parqueadero.classes.Tiempo;


@Service
@Configurable
public class VehiculoCRUD {
	
	@Autowired
	private ParqueaderoRepository parqueaderoRepository;
	
	private VehiculoModel vehiculoModel;
	
	private List<VehiculoModel> listVehiculos;
	/**
	 * 
	 * @param placa
	 * @param tipo
	 * @param cilindraje
	 * @return true if save correctly in the data base
	 */
	public boolean save(String placa, String tipo, short cilindraje,Tiempo tiempo) {
		vehiculoModel = new VehiculoModel(placa, tipo, cilindraje);
		vehiculoModel.setFechaIngreso(tiempo.getDate());
		vehiculoModel.setEstado("true");
		vehiculoModel.setIngresoTimestamp(tiempo.getTimestamp());
		try {
			parqueaderoRepository.save(vehiculoModel);
			return true;
		}catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	/**
	 * 
	 * @param placa
	 * @return true if the car or motorbike exist in the data base
	 */
	public boolean findIntoParking(String placa) {
		try{
			return parqueaderoRepository.existsById(placa);
		}catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @param placa
	 * @return validate the state of the car or motorbike, if it is in or out of the parking
	 */
	public boolean validateVehiculo(String placa) {
		try {
			vehiculoModel = parqueaderoRepository.getOne(placa);
			return vehiculoModel.getEstado().equals("true");
		}catch(Exception e) {
			return false;
		}

	}
	
	/**
	 * 
	 * @param placa
	 * @return the car o motorbike
	 */
	public VehiculoModel findVehiculo(String placa) {
		try {
			return parqueaderoRepository.getOne(placa);
		}catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param placa
	 * @return true if the update was success
	 */
	public boolean updateVehiculo(String placa, Tiempo tiempo) {
		try {
			vehiculoModel = parqueaderoRepository.getOne(placa);
			vehiculoModel.setEstado("true");
			vehiculoModel.setFechaIngreso(tiempo.getDate());
			vehiculoModel.setIngresoTimestamp(tiempo.getTimestamp());
			parqueaderoRepository.save(vehiculoModel);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public boolean updateSalidaVehiculo(String placa) {
		
		try {
			vehiculoModel = parqueaderoRepository.getOne(placa);
			vehiculoModel.setEstado("false");
			parqueaderoRepository.save(vehiculoModel);
			return true;
		}catch(Exception e) {
			return false;
		}


	}
	/**
	 * 
	 * @param estado
	 * @return
	 */
	public short[] numCarsInParking() {
		listVehiculos = parqueaderoRepository.findAll();
		short vehiculos[] = new short[2];
		for(VehiculoModel dato: listVehiculos) {
			if(dato.getEstado().equals("true")) {
				if(dato.getTipo().equals("moto")) {
					vehiculos[0]++;
				}else{
					vehiculos[1]++;
				}
			}
		}
		return vehiculos;
	}
	
	//paraTests
	public void setParqueaderoRepository(ParqueaderoRepository parqueaderoRepository) {
		this.parqueaderoRepository = parqueaderoRepository;
	}
	
	public void setVehiculoModel(VehiculoModel vehiculoModel) {
		this.vehiculoModel = vehiculoModel;
	}
}
