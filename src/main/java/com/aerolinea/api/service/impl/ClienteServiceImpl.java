package com.aerolinea.api.service.impl;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.entity.Equipaje;
import com.aerolinea.api.model.repository.ClienteRepository;
import com.aerolinea.api.model.repository.EquipajeRepository;
import com.aerolinea.api.model.repository.ReservasVueloRepository;
import com.aerolinea.api.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EquipajeRepository equipajeRepository;
	@Autowired
	private ReservasVueloRepository reservasVueloRepository;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	@Override
	public Boolean isUsed(Cliente cliente) {
		if (equipajeRepository.findByClienteId(cliente.getId()).isEmpty()
				&& reservasVueloRepository.findByCliente(cliente).isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public Cliente MapNewToOld(Cliente oldCliente, Cliente newCliente) {
		oldCliente.setNombre(newCliente.getNombre());
		oldCliente.setApPaterno(newCliente.getApPaterno());
		oldCliente.setApMaterno(newCliente.getApMaterno());
		oldCliente.setEdad(newCliente.getEdad());
		oldCliente.setSexo(newCliente.getSexo());
		oldCliente.setTelefono(newCliente.getTelefono());
		oldCliente.setPeso(newCliente.getPeso());
		return oldCliente;
	}

	@Override
	public List<Cliente> findByTelefono(Integer telefono) {
		return clienteRepository.findByTelefono(telefono);
	}

	@Override
	public List<Cliente> findByCorreo(String correo) {
		return clienteRepository.findByCorreoContainingIgnoreCase(correo);
	}

	@Override
	public List<Cliente> findByNombre(String nombre) {
		return clienteRepository.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public List<Cliente> findByApPaterno(String apellido) {
		return clienteRepository.findByapPaternoContainingIgnoreCase(apellido);
	}

	@Override
	public List<Cliente> findByApMaterno(String apellido) {
		return clienteRepository.findByapMaternoContainingIgnoreCase(apellido);
	}

	@Override
	public List<Cliente> findAllByOrden(String orden) {
		return null;
	}

	@Override
	public Cliente findByEquipajeId(Long id) {
		return  clienteRepository.findByEquipajeId(id);
	}

	@Override
	public Equipaje findByIdAndEquipajeById(Long id,Long idEquipaje) {
		return equipajeRepository.findByIdAndEquipajeById(id,idEquipaje);
	}

	@Override
	public void agregarEquipaje(Equipaje equipaje) {
		equipajeRepository.save(equipaje);
	}

	@Override
	public Equipaje findEquipajeById(Long id) {
		return equipajeRepository.findById(id).orElse(null);
	}
	
	@Override
	public Equipaje MapNewToOldEquipaje(Equipaje oldEquipaje, Equipaje newEquipaje) {
		oldEquipaje.setPeso(newEquipaje.getPeso());
		oldEquipaje.setResistencia(newEquipaje.getResistencia());
		oldEquipaje.setAltoY(newEquipaje.getAltoY());
		oldEquipaje.setAnchoZ(newEquipaje.getAnchoZ());
		oldEquipaje.setLargoX(newEquipaje.getLargoX());
		return oldEquipaje;
	}

}
