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
import com.aerolinea.api.service.EquipajeService;
import com.aerolinea.api.service.utils.constants.CommonWords;
import com.aerolinea.api.service.utils.constants.SQLConstants;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;
import com.aerolinea.api.service.utils.rowmapper.EquipajeRowMapper;

@Service
public class EquipajeServiceImpl implements EquipajeService {

	private static final Logger log = LoggerFactory.getLogger(EquipajeServiceImpl.class);
	@Autowired
	private EquipajeRepository equipajeRepository;

	@Autowired
	private ClienteRepository clientesRepository;

	@Autowired
	private JdbcTemplate JDBC;

	@Override
	public List<Equipaje> findAllByOrden(String orden) {
		String sql = SQLConstants.SELECT_ALL.getConstant() + TablesAndAttributesName.EQUIPAJE + CommonWords.ESPACIO
				+ SQLConstants.ORDER.getConstant() + SQLConstants.BY.getConstant() + orden;
		log.info(sql);
		return JDBC.query(sql, new EquipajeRowMapper());
	}

	@Override
	public List<Equipaje> findAll() {
		return (List<Equipaje>) equipajeRepository.findAll();
	}

	@Override
	public Equipaje findById(Long id) {
		return equipajeRepository.findById(id).orElse(null);
	}

	@Override
	public Equipaje save(Equipaje equipaje) {
		return equipajeRepository.save(equipaje);
	}

	@Override
	public void delete(Equipaje equipaje) {
		equipajeRepository.delete(equipaje);
	}

	@Override
	public List<Cliente> findCliente(List<Equipaje> equipaje) {
		return clientesRepository.findByEqupajeIn(equipaje);
	}

	@Override
	public Equipaje MapNewToOld(Equipaje oldEquipaje, Equipaje newEquipaje) {
		oldEquipaje.setPeso(newEquipaje.getPeso());
		oldEquipaje.setResistencia(newEquipaje.getResistencia());
		oldEquipaje.setAltoY(newEquipaje.getAltoY());
		oldEquipaje.setAnchoZ(newEquipaje.getAnchoZ());
		oldEquipaje.setLargoX(newEquipaje.getLargoX());
		return oldEquipaje;
	}

	@Override
	public Boolean isUsed(Equipaje entity) {
		return false;
	}

	@Override
	public List<Equipaje> findByClienteId(Long id) {
		return equipajeRepository.findByClienteId(id);
	}

	
}
