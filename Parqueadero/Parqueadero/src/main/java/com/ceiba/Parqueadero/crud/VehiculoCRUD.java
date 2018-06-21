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
		return parqueaderoRepository.existsById(placa);
	}
	
	/**
	 * 
	 * @param placa
	 * @return validate the state of the car or motorbike, if it is in or out of the parking
	 */
	public boolean validateVehiculo(String placa) {
		vehiculoModel = parqueaderoRepository.getOne(placa);
		return vehiculoModel.getEstado().equals("true");
	}
	
	/**
	 * 
	 * @param placa
	 * @return the car o motorbike
	 */
	public VehiculoModel findVehiculo(String placa) {
		return parqueaderoRepository.getOne(placa);
	}
	
	/**
	 * 
	 * @param placa
	 * @return true if the update was success
	 */
	public boolean updateVehiculo(String placa, Tiempo tiempo) {
		vehiculoModel = parqueaderoRepository.getOne(placa);
		vehiculoModel.setEstado("true");
		vehiculoModel.setFechaIngreso(tiempo.getDate());
		try {
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
		System.out.println("Entre");
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
}
