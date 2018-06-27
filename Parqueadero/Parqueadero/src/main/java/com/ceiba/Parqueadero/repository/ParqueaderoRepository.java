package com.ceiba.Parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.Parqueadero.model.VehiculoModel;

@Repository
public interface ParqueaderoRepository  extends JpaRepository<VehiculoModel,String>{
	
}
