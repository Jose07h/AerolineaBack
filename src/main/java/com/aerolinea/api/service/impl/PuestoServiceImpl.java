package com.aerolinea.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.aerolinea.api.model.entity.Puesto;
import com.aerolinea.api.model.repository.EmpleadoRepository;
import com.aerolinea.api.model.repository.PuestoRepository;
import com.aerolinea.api.service.PuestoService;
import com.aerolinea.api.service.utils.constants.SQLConstants;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;
import com.aerolinea.api.service.utils.rowmapper.PuestoRowMapper;

@Service
public class PuestoServiceImpl implements PuestoService {

	private static final Logger log = LoggerFactory.getLogger(PuestoServiceImpl.class);

	@Autowired
	private PuestoRepository puestoRepository;

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private JdbcTemplate JDBC;

	@Override
	public List<Puesto> findAll() {
		return (List<Puesto>) puestoRepository.findAll();
	}

	@Override
	public List<Puesto> findByOrden(String orden) {
		String sql = SQLConstants.SELECT_ALL.getConstant() + TablesAndAttributesName.PUESTOS + " " + SQLConstants.ORDER.getConstant()
				+ SQLConstants.BY.getConstant() + orden;
		log.info(sql);
		return JDBC.query(sql, new PuestoRowMapper());
	}

	@Override
	public List<Puesto> findByPuesto(String puesto) {
		return puestoRepository.findByPuesto(puesto);
	}

	@Override
	public Puesto findById(Integer id) {
		return puestoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Puesto> findByTurno(String turno) {
		return puestoRepository.findByTurno(turno);
	}

	@Override
	public Puesto save(Puesto puesto) {
		return puestoRepository.save(puesto);
	}

	@Override
	public void delete(Puesto puesto) {
		puestoRepository.delete(puesto);
	}

	@Override
	public Boolean isUsed(Puesto puesto) {
		if (empleadoRepository.countByPuesto(puesto)>0) {
			return true;
		}
		return false;
	}

	@Override
	public Puesto MapNewToOld(Puesto oldPuesto, Puesto newPuesto) {
		oldPuesto.setPuesto(newPuesto.getPuesto());
		oldPuesto.setTurno(newPuesto.getTurno());
		oldPuesto.setSalario(newPuesto.getSalario());
		return oldPuesto;
	}

	
}
