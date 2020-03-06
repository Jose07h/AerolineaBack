package com.aerolinea.api.service;

import java.util.List;

import com.aerolinea.api.model.entity.Puesto;

public interface PuestoService {

	public List<Puesto> findAll();

	public List<Puesto> findByOrden(String orden);

	public List<Puesto> findByPuesto(String puesto);

	public Puesto findById(Integer id);

	public List<Puesto> findByTurno(String turno);
	
	public Puesto save(Puesto puesto) ;
	
	public void delete(Puesto puesto);
	
	public Boolean isUsedInEmpleados(Puesto puesto);

}