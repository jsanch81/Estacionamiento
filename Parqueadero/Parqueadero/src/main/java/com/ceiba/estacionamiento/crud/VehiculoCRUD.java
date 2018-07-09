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
	 * This method saves a new vehicle in the database.
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
	 * This method makes a query to know if a vehicle exists in the data base.
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
	 * This method validates if a vehicle is in the parking
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
	 * This method searches a vehicle in the database and return it.
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
	 * This method updates the state of a vehicle and date of get in. 
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
	
	/**
	 * This method change the state of the vehicle in the data base.
	 * @param placa
	 * @return
	 */
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
	 * This method calculates the values of motorbikes and cars are into the parking
	 * @param estado
	 * @return
	 */
	public short[] numCarsInParking() {
		listaVehiculos = parqueaderoRepository.findAll();
		short[] vehiculos = new short[2];
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
	
	/**
	 * This method get the list of cars and motorbikes are into the parking
	 * @param tiempo
	 * @return
	 */
	public List<Vehiculos> vehiculosParqueados(Tiempo tiempo) {
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
	
}
