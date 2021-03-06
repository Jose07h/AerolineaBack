package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Puesto;
import com.aerolinea.api.service.utils.constants.TablesName;

public interface PuestoRepository extends CrudRepository<Puesto, Integer> {

	@Query(value = "SELECT * FROM "+TablesName.PUESTOS +" WHERE lower(translate(puesto, 'áéíóú', 'aeiou')) like %?1%",nativeQuery = true)
	public List<Puesto> findByPuesto(String puesto);

	public List<Puesto> findByTurno(String turno);

}
