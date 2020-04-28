package com.aerolinea.api.service;

import java.util.List;

import com.aerolinea.api.model.entity.Empleado;
import com.aerolinea.api.service.generic.ServiceGeneric;

public interface EmpleadoService extends ServiceGeneric<Empleado> {

	public List<Empleado> findAll();

	public List<Empleado> findByNombre(String nombre);

	public List<Empleado> findByApPaterno(String apPaterno);

	public List<Empleado> findByCorreo(String correo);

	public Empleado findById(Long id);

	public List<Empleado> findByDisponible(Boolean disponible);

	public Empleado save(Empleado empleado);

	public void delete(Empleado empleado);

	public Boolean isUsed(Empleado empleado);

	public Empleado MapNewToOld(Empleado oldEmpleado, Empleado newEmpleado);
	
	public Empleado changeAvalibleByEmpleadoId(Long id);

}