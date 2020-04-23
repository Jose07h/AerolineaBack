package com.aerolinea.api.service.utils.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aerolinea.api.model.entity.Equipaje;

public class EquipajeRowMapper implements RowMapper<Equipaje> {

	@Override
	public Equipaje mapRow(ResultSet rs, int rowNum) throws SQLException {
		Equipaje equipaje = new Equipaje();
		equipaje.setId(rs.getLong("id"));
		equipaje.setPeso(rs.getInt("peso"));
		equipaje.setResistencia(rs.getInt("resistencia"));
		equipaje.setAltoY(rs.getInt("alto_y"));
		equipaje.setAnchoZ(rs.getInt("ancho_z"));
		equipaje.setLargoX(rs.getInt("largo_x"));
		return equipaje;
	}

}
