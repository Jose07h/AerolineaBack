package com.aerolinea.api.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Avion;
import com.aerolinea.api.model.entity.Destino;
import com.aerolinea.api.model.entity.Vuelo;

public interface VuelosRepository extends CrudRepository<Vuelo, Long> {

	public Integer countByDestino(Destino destino);

	public Integer countByAvion(Avion avion);

	@Query(value = "SELECT COUNT(1) FROM personal_vuelo WHERE id_empleado=?1",nativeQuery = true)
	public Integer countByEmpleadoId(Long id);
	
}
