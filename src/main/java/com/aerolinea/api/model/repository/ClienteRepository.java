package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.entity.Equipaje;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	public List<Cliente> findByNombreContainingIgnoreCase(String nombre);

	public List<Cliente> findByapPaternoContainingIgnoreCase(String apellido);

	public List<Cliente> findByapMaternoContainingIgnoreCase(String apellido);

	public List<Cliente> findByEqupajeIn(List<Equipaje> equpaje);
	
	public List<Cliente> findByCorreoContainingIgnoreCase(String correo);
	
	public List<Cliente> findByTelefono(Integer telefono);
	
	@Query(value = "select * from clientes :orden",nativeQuery = true)
	public List<Cliente> findByOrden(String orden);
	@Query(value = "SELECT DISTINCT C.* FROM CLIENTES C,EQUIPAJE E WHERE E.ID_CLIENTE=C.ID AND E.ID= ?1 ; ",nativeQuery = true)
	public Cliente findByEquipajeId(Long id);
}
 