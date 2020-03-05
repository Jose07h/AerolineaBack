package com.aerolinea.api.model.repository;

import org.springframework.data.repository.CrudRepository; 

import com.aerolinea.api.model.entity.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{

}
