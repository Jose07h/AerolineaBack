package com.aerolinea.api.service.utils.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aerolinea.api.model.entity.Destino;

public class DestinoRowMapper implements RowMapper<Destino>{

	@Override
	public Destino mapRow(ResultSet rs, int rowNum) throws SQLException {
		Destino destino=new Destino();
		destino.setId(rs.getLong("id"));
		destino.setCiudad(rs.getString("ciudad"));
		destino.setPais(rs.getString("pais"));
		destino.setDisponible(rs.getBoolean("disponible"));
		return destino;
	}
	

}
