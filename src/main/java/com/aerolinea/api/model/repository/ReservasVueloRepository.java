package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.CategoriasVuelos;
import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.entity.ReservasVuelo;
import com.aerolinea.api.model.entity.Vuelo;

public interface ReservasVueloRepository extends CrudRepository<ReservasVuelo, Long> {
	
	public List<ReservasVuelo> findByCliente(Cliente cliente);

	@Query(value = "Select count(1) from RESERVAS_VUELOS where id_cliente=?1", nativeQuery = true)
	public Integer countByVueloId(Long id);

	List<ReservasVuelo> findByVuelo(Vuelo vuelo);
	
	List<ReservasVuelo> findByNumeroAsiento(String numeroAsiento);
	
	List<ReservasVuelo> findByCategoria(CategoriasVuelos categoria);
	
	@Query(value="SELECT R FROM ReservasVuelo R join fetch R.cliente C join fetch R.vuelo V WHERE R.id=?1")
	Object findByidWithClienteWithVuelo(Long id);
	
}
