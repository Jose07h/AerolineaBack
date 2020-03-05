package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	public List<Cliente> findByNombre(String nombre);

	public List<Cliente> findByapPaterno(String apellido);

	public List<Cliente> findByapMaterno(String apellido);

}
