package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.entity.ReservasVuelo;



public interface ReservasVueloRepository extends CrudRepository<ReservasVuelo, Long>{
	public List
	<ReservasVuelo> findByCliente(Cliente cliente);
	
}
