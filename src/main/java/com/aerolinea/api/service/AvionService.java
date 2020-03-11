package com.aerolinea.api.service;

import java.util.List;

import com.aerolinea.api.model.entity.Avion;
import com.aerolinea.api.service.generic.ServiceGeneric;

public interface AvionService extends ServiceGeneric<Avion>{

	public List<Avion> findAll();

	public List<Avion> findByModelo(String modelo);

	public Avion findById(Long id);

	public List<Avion> findByDisponible(Boolean disponible);
	
	public Avion save(Avion avion) ;
	
	public void delete(Avion avion);
	
	public Boolean isUsed(Avion avion);

	public Avion MapNewToOld(Avion oldAvion, Avion newAvion) ;
	
}