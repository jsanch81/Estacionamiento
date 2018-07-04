package com.ceiba.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.estacionamiento.model.VehiculoModel;

@Repository
public interface ParqueaderoRepository  extends JpaRepository<VehiculoModel,String>{
	
}
