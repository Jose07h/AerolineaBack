package com.aerolinea.api.service;

import java.util.List;

import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.entity.Equipaje;
import com.aerolinea.api.service.generic.ServiceGeneric;

public interface EquipajeService extends ServiceGeneric<Equipaje>{

	public List<Equipaje> findAll();

	public Equipaje findById(Long id);
	
	public Equipaje save(Equipaje equipaje) ;
	
	public void delete(Equipaje equipaje);
	
	public List<Cliente> findCliente(List<Equipaje> equipaje) ;

	public Equipaje MapNewToOld(Equipaje oldEquipaje, Equipaje newEquipaje) ;
	
	public List<Equipaje> findByClienteId(Long id);	
}