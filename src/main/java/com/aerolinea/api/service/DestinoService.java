package com.aerolinea.api.service;

import java.util.List;

import com.aerolinea.api.model.entity.Destino;
import com.aerolinea.api.service.generic.ServiceGeneric;

public interface DestinoService extends ServiceGeneric<Destino>{
	public List<Destino> findAll();

	public List<Destino> findByOrden(String orden);

	public List<Destino> findByCiudad(String ciudad);

	public List<Destino> findByPais(String pais);

	public Destino findById(Integer id);

	public Destino save(Destino destino);

	public void delete(Destino destino);
	
	public List<Destino> findByDisponible(Boolean disponible);
	
	public Boolean isUsed(Destino destino);
	
	public Destino MapNewToOld(Destino oldDestino, Destino newDestino);
	
}
