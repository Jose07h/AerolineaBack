package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Destino;

public interface DestinoRepository extends CrudRepository<Destino, Long> {
	
	@Query(value = "select * from destinos where lower(translate(ciudad, 'áéíóú', 'aeiou')) like %?1%",nativeQuery = true)
	public List<Destino> findByCiudadLike(String ciudad);
	@Query(value = "select * from destinos where lower(translate(pais, 'áéíóú', 'aeiou')) like %?1%",nativeQuery = true)
	public List<Destino> findByPaisLike(String pais);
			
	public List<Destino> findByDisponible(Boolean disponible);
}
