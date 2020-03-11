package com.aerolinea.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.aerolinea.api.model.entity.Destino;
import com.aerolinea.api.model.repository.DestinoRepository;
import com.aerolinea.api.model.repository.VuelosRepository;
import com.aerolinea.api.service.DestinoService;
import com.aerolinea.api.service.utils.constants.SQLConstants;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;
import com.aerolinea.api.service.utils.rowmapper.DestinoRowMapper;

@Service
public class DestinoServiceImpl implements DestinoService {

	private static final Logger log = LoggerFactory.getLogger(PuestoServiceImpl.class);

	@Autowired
	private DestinoRepository destinoRespository;

	@Autowired 
	private VuelosRepository vuelosRepository;
	
	@Autowired
	private JdbcTemplate JDBC;

	@Override
	public List<Destino> findAll() {
		return (List<Destino>) destinoRespository.findAll();
	}

	@Override
	public List<Destino> findByOrden(String orden) {
		String sql = SQLConstants.SELECT_ALL.getConstant() + TablesAndAttributesName.DESTINOS + " "
				+ SQLConstants.ORDER.getConstant() + SQLConstants.BY.getConstant() + orden;
		log.info(sql);
		return JDBC.query(sql, new DestinoRowMapper());
	}

	@Override
	public List<Destino> findByCiudad(String ciudad) {
		return findByCiudad(ciudad);
	}

	@Override
	public List<Destino> findByPais(String pais) {
		return destinoRespository.findByPaisLike(pais);
	}

	@Override
	public Destino findById(Integer id) {
		return destinoRespository.findById(id).orElse(null);
	}

	@Override
	public Destino save(Destino destino) {
		return destinoRespository.save(destino);
	}

	@Override
	public void delete(Destino destino) {
		destinoRespository.delete(destino);
	}
	
	@Override
	public List<Destino> findByDisponible(Boolean disponible) {
		return destinoRespository.findByDisponible(disponible);
	}

	@Override
	public Boolean isUsed(Destino destino) {
		if (vuelosRepository.countByDestino(destino)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Destino MapNewToOld(Destino oldDestino, Destino newDestino) {
		oldDestino.setPais(newDestino.getPais());
		oldDestino.setCiudad(newDestino.getCiudad());
		oldDestino.setDisponible(newDestino.getDisponible());
		return oldDestino;
	}

}
