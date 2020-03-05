package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Puesto;

public interface PuestoRepository extends CrudRepository<Puesto, Integer> {

	public List<Puesto> findByPuesto(String puesto);

	public List<Puesto> findByTurno(String turno);

}
