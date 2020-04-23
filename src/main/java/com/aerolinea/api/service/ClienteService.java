package com.aerolinea.api.service;

import java.util.List;

import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.entity.Equipaje;
import com.aerolinea.api.service.generic.ServiceGeneric;

public interface ClienteService extends ServiceGeneric<Cliente> {

	public List<Cliente> findAll();

	public Cliente findById(Long id);

	public Cliente save(Cliente cliente);

	public void delete(Cliente cliente);

	public Boolean isUsed(Cliente cliente);

	public Cliente MapNewToOld(Cliente oldCliente, Cliente newCliente);

	public List<Cliente> findAllByOrden(String orden);

	public List<Cliente> findByTelefono(Integer telefono);

	public List<Cliente> findByCorreo(String correo);

	public List<Cliente> findByNombre(String nombre);

	public List<Cliente> findByApPaterno(String apellido);

	public List<Cliente> findByApMaterno(String apellido);
	
	public Cliente findByEquipajeId(Long id);
}