package com.ceiba.estacionamiento.crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.dominio.Tiempo;
import com.ceiba.estacionamiento.modelos.VehiculoModel;
import com.ceiba.estacionamiento.modelos.Vehiculos;
import com.ceiba.estacionamiento.repository.ParqueaderoRepository;


@Service
@Configurable
public class VehiculoCRUD {
	
	@Autowired
	private ParqueaderoRepository parqueaderoRepository;
	
	private VehiculoModel vehiculoModel;
	
	private List<VehiculoModel> listaVehiculos;
	
	/**
	 * 
	 * @param placa
	 * @param tipo
	 * @param cilindraje
	 * @return true if save correctly in the data base
	 */
	public boolean guardar(String placa, String tipo, short cilindraje,Tiempo tiempo) {
		vehiculoModel = new VehiculoModel(placa, tipo, cilindraje);
		vehiculoModel.setFechaIngreso(tiempo.getDate());
		vehiculoModel.setEstado("true");
		vehiculoModel.setIngresoTimestamp(tiempo.getTimestamp());
		try {
			parqueaderoRepository.save(vehiculoModel);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @param placa
	 * @return true if the car or motorbike exist in the data base
	 */
	public boolean vehiculoRegistrado(String placa) {
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
	public boolean vehiculoParqueado(String placa) {
		try {
			vehiculoModel = parqueaderoRepository.findById(placa).get();
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
	public VehiculoModel buscarVehiculo(String placa) {
		try {
			return parqueaderoRepository.findById(placa).get();
		}catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param placa
	 * @return true if the update was success
	 */
	public boolean actualizarVehiculo(String placa, Tiempo tiempo) {
		try {
			vehiculoModel = parqueaderoRepository.findById(placa).get();
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
			vehiculoModel = parqueaderoRepository.findById(placa).get();
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
		listaVehiculos = parqueaderoRepository.findAll();
		short vehiculos[] = new short[2];
		for(VehiculoModel dato: listaVehiculos) {
			if("true".equals(dato.getEstado())) {
				if("moto".equals(dato.getTipo())) {
					vehiculos[0]++;
				}else{
					vehiculos[1]++;
				}
			}
		}
		return vehiculos;
	}
	
	public List<Vehiculos> vehiculosIntoParking(Tiempo tiempo) {
		List<Vehiculos> listIntoVehiculos = new ArrayList<>();
		listaVehiculos = parqueaderoRepository.findAll();
		for(VehiculoModel dato: listaVehiculos) {
			if("true".equals(dato.getEstado())) {
				String date = tiempo.dateToString(dato.getFechaIngreso());
				Vehiculos vehiculos = new Vehiculos(dato.getPlaca(),date,dato.getTipo());
				listIntoVehiculos.add(vehiculos);
			}
		}
		return listIntoVehiculos;
	}
	
	//paraTests
	public void setParqueaderoRepository(ParqueaderoRepository parqueaderoRepository) {
		this.parqueaderoRepository = parqueaderoRepository;
	}
	
	public void setVehiculoModel(VehiculoModel vehiculoModel) {
		this.vehiculoModel = vehiculoModel;
	}
}
