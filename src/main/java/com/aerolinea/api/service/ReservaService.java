package com.aerolinea.api.service;

import java.util.List;

import com.aerolinea.api.model.entity.ReservasVuelo;
import com.aerolinea.api.model.entity.Vuelo;
import com.aerolinea.api.model.entity.CategoriasVuelos;
import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.service.generic.ServiceGeneric;

public interface ReservaService extends ServiceGeneric<ReservasVuelo> {

	public List<ReservasVuelo> findAll();

	public ReservasVuelo findById(Long id);

	public ReservasVuelo save(ReservasVuelo eeservasVuelo);

	public void delete(ReservasVuelo eeservasVuelo);

	public Boolean isUsed(ReservasVuelo eeservasVuelo);

	public ReservasVuelo MapNewToOld(ReservasVuelo oldReservasVuelo, ReservasVuelo newReservasVuelo);

	public List<ReservasVuelo> findByNumeroAsiento(String numero);

	public List<ReservasVuelo> findByCategoria(CategoriasVuelos categoria);

	public List<ReservasVuelo> findByCliente(Cliente cliente);

	public List<ReservasVuelo> findByVuelo(Vuelo vuelo);
	
	public CategoriasVuelos findByCategoriaId(Long id);
	
	public Vuelo findByVueloId(Long id);
	
	public Cliente findByClienteId(Long id);
	
	public ReservasVuelo findByidWithClienteWithVuelo(Long id);

}