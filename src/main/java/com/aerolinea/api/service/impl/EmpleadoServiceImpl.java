package com.aerolinea.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.api.model.entity.Empleado;
import com.aerolinea.api.model.repository.EmpleadoRepository;
import com.aerolinea.api.model.repository.VuelosRepository;
import com.aerolinea.api.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private VuelosRepository vuelosRepository;

	@Override
	public List<Empleado> findAll() {
		return (List<Empleado>) empleadoRepository.findAll();
	}

	@Override
	public List<Empleado> findByNombre(String nombre) {
		return empleadoRepository.findByNombreContaining(nombre.toLowerCase());
	}

	@Override
	public Empleado findById(Long id) {
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Empleado> findByDisponible(Boolean disponible) {
		return empleadoRepository.findByOcupado(disponible);
	}

	@Override
	public Empleado save(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public void delete(Empleado empleado) {
		empleadoRepository.delete(empleado);
	}

	@Override
	public Boolean isUsed(Empleado empleado) {
		if (vuelosRepository.countByEmpleadoId(empleado.getId()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Empleado MapNewToOld(Empleado oldEmpleado, Empleado newEmpleado) {
		oldEmpleado.setNombre(newEmpleado.getNombre());
		oldEmpleado.setApPaterno(newEmpleado.getApPaterno());
		oldEmpleado.setApMaterno(newEmpleado.getApMaterno());
		oldEmpleado.setOcupado(newEmpleado.getOcupado());
		oldEmpleado.setEdad(newEmpleado.getEdad());
		oldEmpleado.setCorreo(newEmpleado.getCorreo());
		oldEmpleado.setSexo(newEmpleado.getSexo());
		oldEmpleado.setTelefono(newEmpleado.getTelefono());
		return oldEmpleado;
	}

	@Override
	public List<Empleado> findByApPaterno(String apPaterno) {
		return empleadoRepository.findByApPaternoContaining(apPaterno.toLowerCase());
	}

	@Override
	public List<Empleado> findAllByOrden(String orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> findByCorreo(String correo) {
		return empleadoRepository.findByCorreoContaining(correo.toLowerCase());
	}

	@Override
	public Empleado changeAvalibleByEmpleadoId(Long id) {
		Empleado empleado = empleadoRepository.findById(id).orElse(null);
		empleado.setOcupado(!empleado.getOcupado());
		return empleadoRepository.save(empleado);
	}

}
