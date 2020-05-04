package com.aerolinea.api.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Avion;
import com.aerolinea.api.model.entity.Destino;
import com.aerolinea.api.model.entity.Vuelo;

public interface VuelosRepository extends CrudRepository<Vuelo, Long> {

	@Query(value = "SELECT v,d,a FROM Vuelo v join v.destino d join v.avion a ")
	public List<Vuelo> findAll();
	
	public Integer countByDestino(Destino destino);

	public Integer countByAvion(Avion avion);

	@Query(value = "SELECT COUNT(1) FROM personal_vuelo WHERE id_empleado=?1",nativeQuery = true)
	public Integer countByEmpleadoId(Long id);
	
	@Query(value = "SELECT v,d,a FROM Vuelo v join v.destino d join v.avion a  WHERE d.pais=?1")
	public List<Vuelo> findByDestinoPais(String pais);
	
	@Query(value = "SELECT v,d,a FROM Vuelo v join v.destino d join v.avion a  WHERE d.ciudad=?1")
	public List<Vuelo> findByDestinoCiudad(String ciudad);
	
	public List<Vuelo> findByFechaAndDestino(Destino destino ,LocalDate date);
	
	public List<Vuelo> findByDestino(Destino destino);

}
