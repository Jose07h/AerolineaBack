package com.aerolinea.api.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Avion;

public interface AvionRepository extends CrudRepository<Avion, Integer>{

}
