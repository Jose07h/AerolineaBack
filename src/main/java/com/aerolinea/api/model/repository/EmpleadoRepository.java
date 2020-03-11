package com.aerolinea.api.model.repository;

import org.springframework.data.repository.CrudRepository; 

import com.aerolinea.api.model.entity.Empleado;
import com.aerolinea.api.model.entity.Puesto;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{
	public Integer countByPuesto(Puesto puesto);
}
