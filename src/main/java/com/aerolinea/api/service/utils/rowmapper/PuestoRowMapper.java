package com.aerolinea.api.service.utils.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aerolinea.api.model.entity.Puesto;

public class PuestoRowMapper implements RowMapper<Puesto>{

	@Override
	public Puesto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Puesto puesto=new Puesto();
		puesto.setId(rs.getInt("id"));
		puesto.setPuesto(rs.getString("puesto"));
		puesto.setTurno(rs.getString("turno"));
		puesto.setSalario(rs.getInt("salario"));
		return puesto;
	}

}
