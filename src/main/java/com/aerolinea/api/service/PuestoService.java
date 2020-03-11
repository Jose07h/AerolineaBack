package com.aerolinea.api.service;

import java.util.List;

import com.aerolinea.api.model.entity.Puesto;
import com.aerolinea.api.service.generic.ServiceGeneric;

public interface PuestoService extends ServiceGeneric<Puesto>{

	public List<Puesto> findAll();

	public List<Puesto> findByPuesto(String puesto);

	public Puesto findById(Long id);

	public List<Puesto> findByTurno(String turno);
	
	public Puesto save(Puesto puesto) ;
	
	public void delete(Puesto puesto);
	
	public Boolean isUsed(Puesto puesto);

	public Puesto MapNewToOld(Puesto oldPuesto, Puesto newPuesto) ;
	
	public List<Puesto> findAllByOrden(String orden);
}