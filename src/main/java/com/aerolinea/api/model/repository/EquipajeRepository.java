package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Equipaje;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;;

public interface EquipajeRepository extends CrudRepository<Equipaje, Long> {
	@Query(value = "select * from " + TablesAndAttributesName.EQUIPAJE + "where id_cliente=?1", nativeQuery = true)
	public List<Equipaje> findByClienteId(Long id);

	@Query(value = "SELECT * FROM " + TablesAndAttributesName.EQUIPAJE
			+ "WHERE id_cliente=?1 AND ID=?2", nativeQuery = true)
	public Equipaje findByIdAndEquipajeById(Long id, Long idEquipaje);
}
