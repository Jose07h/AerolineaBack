package com.aerolinea.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.aerolinea.api.model.entity.Avion;
import com.aerolinea.api.model.repository.AvionRepository;
import com.aerolinea.api.model.repository.VuelosRepository;
import com.aerolinea.api.service.AvionService;
import com.aerolinea.api.service.utils.constants.CommonWords;
import com.aerolinea.api.service.utils.constants.SQLConstants;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;
import com.aerolinea.api.service.utils.rowmapper.AvionRowMapper;

@Service
public class AvionServiceImpl implements AvionService {

	private static final Logger log = LoggerFactory.getLogger(AvionServiceImpl.class);
	@Autowired
	private AvionRepository avionRepository;

	@Autowired
	private VuelosRepository vuelosRepository;

	@Autowired
	private JdbcTemplate JDBC;

	@Override
	public List<Avion> findAllByOrden(String orden) {
		String sql = SQLConstants.SELECT_ALL.getConstant() + TablesAndAttributesName.AVIONES + CommonWords.ESPACIO
				+ SQLConstants.ORDER.getConstant() + SQLConstants.BY.getConstant() + orden;
		log.info(sql);
		return JDBC.query(sql, new AvionRowMapper());
	}

	@Override
	public List<Avion> findAll() {
		return (List<Avion>) avionRepository.findAll();
	}

	@Override
	public List<Avion> findByModelo(String modelo) {
		return avionRepository.findByModelo(modelo);
	}

	@Override
	public Avion findById(Long id) {
		return avionRepository.findById(id).orElse(null);
	}

	@Override
	public List<Avion> findByDisponible(Boolean disponible) {
		return avionRepository.findByDisponible(disponible);
	}

	@Override
	public Avion save(Avion avion) {
		return avionRepository.save(avion);
	}

	@Override
	public void delete(Avion avion) {
		avionRepository.delete(avion);
	}

	@Override
	public Boolean isUsed(Avion avion) {
		if (vuelosRepository.countByAvion(avion)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Avion MapNewToOld(Avion oldAvion, Avion newAvion) {
		oldAvion.setModelo(newAvion.getModelo());
		oldAvion.setCantidadPasajeros(newAvion.getCantidadPasajeros());
		oldAvion.setCantidadMotores(newAvion.getCantidadMotores());
		oldAvion.setDisponible(newAvion.getDisponible());
		oldAvion.setPesoMaximo(newAvion.getPesoMaximo());
		oldAvion.setVelocidadMaxima(newAvion.getVelocidadMaxima());
		return oldAvion;
	}

}
