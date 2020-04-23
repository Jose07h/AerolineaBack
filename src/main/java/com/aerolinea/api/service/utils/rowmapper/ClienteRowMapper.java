package com.aerolinea.api.service.utils.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.repository.EquipajeRepository;

public class ClienteRowMapper implements RowMapper<Cliente>{
	
	@Autowired
	private EquipajeRepository equipajeRepository; 
	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente=new Cliente();
		cliente.setId(rs.getLong("id"));
		cliente.setApPaterno(rs.getString("ap_paterno"));
		cliente.setApMaterno(rs.getString("ap_materno"));
		cliente.setEdad(rs.getInt("edad"));
		cliente.setSexo(rs.getString("sexo"));
		cliente.setTelefono(rs.getInt("telefono"));
		cliente.setPeso(rs.getInt("peso"));
		cliente.setEqupaje(equipajeRepository.findByClienteId(rs.getLong("id")));
		return cliente;
	}
}
