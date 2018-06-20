package com.ceiba.Parqueadero.repository;

import com.ceiba.Parqueadero.model.VehiculoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueaderoRepository  extends JpaRepository<VehiculoModel,String>{
	
}
