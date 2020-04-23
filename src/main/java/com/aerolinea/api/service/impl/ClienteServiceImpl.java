package com.aerolinea.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.entity.Equipaje;
import com.aerolinea.api.model.repository.ClienteRepository;
import com.aerolinea.api.model.repository.EquipajeRepository;
import com.aerolinea.api.model.repository.ReservasVueloRepository;
import com.aerolinea.api.service.ClienteService;
import com.aerolinea.api.service.utils.constants.SQLConstants;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;
import com.aerolinea.api.service.utils.rowmapper.ClienteRowMapper;
@Service
public class ClienteServiceImpl implements ClienteService {

	private static final Logger log = LoggerFactory.getLogger(PuestoServiceImpl.class);

	@Autowired
	private JdbcTemplate JDBC;
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
		return clienteRepository.findByCorreoLike(correo);
	}

	@Override
	public List<Cliente> findByNombre(String nombre) {
		return clienteRepository.findByNombre(nombre);
	}

	@Override
	public List<Cliente> findByApPaterno(String apellido) {
		return clienteRepository.findByapPaterno(apellido);
	}

	@Override
	public List<Cliente> findByApMaterno(String apellido) {
		return clienteRepository.findByapMaterno(apellido);
	}

	@Override
	public List<Cliente> findAllByOrden(String orden) {
		return null;
	}

	@Override
	public Cliente findByEquipajeId(Long id) {
		return  clienteRepository.findByEquipajeId(id);
	}
	

}
