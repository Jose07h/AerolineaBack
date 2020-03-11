package com.aerolinea.api.service.utils.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aerolinea.api.model.entity.Avion;

public class AvionRowMapper implements RowMapper<Avion>{

	@Override
	public Avion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Avion avion= new Avion();
		avion.setId(rs.getLong("id"));
		avion.setModelo(rs.getString("modelo"));
		avion.setCantidadMotores(rs.getInt("cantidad_motores"));
		avion.setVelocidadMaxima(rs.getInt("velocidad_maxima"));
		avion.setCantidadPasajeros(rs.getInt("cantidad_pasajeros"));
		avion.setPesoMaximo(rs.getInt("peso_maximo"));
		avion.setDisponible(rs.getBoolean("disponible"));
		return avion;
	}

}
