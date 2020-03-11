package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Destino;
import com.aerolinea.api.model.entity.Vuelo;



public interface VuelosRepository extends CrudRepository<Vuelo, Integer>{
	
	public Integer countByDestino(Destino destino);
	

}
