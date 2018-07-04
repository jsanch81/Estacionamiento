package com.ceiba.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.model.VehiculoModel;

@Repository
public interface ParqueaderoRepository  extends JpaRepository<VehiculoModel,String>{
	
}
