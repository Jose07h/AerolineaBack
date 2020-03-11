package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Avion;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;

public interface AvionRepository extends CrudRepository<Avion, Long>{
	@Query(value = "SELECT * FROM "+TablesAndAttributesName.AVIONES +" WHERE lower(translate(modelo, 'áéíóú', 'aeiou')) like %?1%",nativeQuery = true)
	public List	<Avion>  findByModelo(String modelo);
	
	public List<Avion> findByDisponible(Boolean disponible);
	
}
