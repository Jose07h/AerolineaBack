package com.aerolinea.api.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Parametro;

public interface ParametroRepository extends CrudRepository<Parametro, Long> {
	public Parametro findByKey(String key);
}
