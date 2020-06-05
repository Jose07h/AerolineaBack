package com.aerolinea.api.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Avion;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;

public interface AvionRepository extends CrudRepository<Avion, Long>{
	@Query(value = "SELECT * FROM "+TablesAndAttributesName.AVIONES +" WHERE lower(translate(modelo, 'áéíóú', 'aeiou')) like %?1%",nativeQuery = true)
	public List	<Avion>  findByModelo(String modelo);
	
	public List<Avion> findByDisponible(Boolean disponible);
	
	@Query("SELECT A FROM Avion A  left join fetch A.vuelosList V left join fetch V.destino D WHERE A.id=?1" )
	public Optional<Avion> findById(Long id);
	
	@Query("SELECT A FROM Avion A left join fetch A.vuelosList V left join fetch V.destino D " )
	public List<Avion> findAll();
	
}
