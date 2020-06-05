package com.aerolinea.api.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.CategoriasVuelos;

public interface CategoriaRepository extends CrudRepository<CategoriasVuelos, Long> {

}
