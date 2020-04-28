package com.aerolinea.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aerolinea.api.model.entity.Empleado;
import com.aerolinea.api.model.entity.Puesto;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
	public Integer countByPuesto(Puesto puesto);

	List<Empleado> findByOcupado(Boolean ocupado);

	@Query(value = "SELECT * FROM " + TablesAndAttributesName.EMPLEADOS
			+ " WHERE lower(translate(correo, 'áéíóú', 'aeiou')) like %?1%", nativeQuery = true)
	List<Empleado> findByCorreoContaining(String correo);

	@Query(value = "SELECT * FROM " + TablesAndAttributesName.EMPLEADOS
			+ " WHERE lower(translate(nombre, 'áéíóú', 'aeiou')) like %?1%", nativeQuery = true)
	List<Empleado> findByNombreContaining(String nombre);

	@Query(value = "SELECT * FROM " + TablesAndAttributesName.EMPLEADOS
			+ " WHERE lower(translate(ap_paterno, 'áéíóú', 'aeiou')) like %?1%", nativeQuery = true)
	List<Empleado> findByApPaternoContaining(String apPaterno);
	
	@Query("SELECT E ,p FROM Empleado E join fetch E.puesto p")
	public  List<Empleado> findAll() ;
	
}
