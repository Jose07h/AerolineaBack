package com.aerolinea.api.service;

import java.time.LocalDate;
import java.util.List;

import com.aerolinea.api.model.entity.Destino;
import com.aerolinea.api.model.entity.Vuelo;
import com.aerolinea.api.service.generic.ServiceGeneric;

public interface VueloService extends ServiceGeneric<Vuelo> {

	public List<Vuelo> findAll();

	public List<Vuelo> findByDestinoCiudad(String nombre);
	
	public List<Vuelo> findByDestinoPais(String nombre);
	
	public List<Vuelo> findByDestino(Destino destino);
	
	public List<Vuelo> findByFechaAndDestino(Destino destino,LocalDate date);
	
	public List<Vuelo> findByFecha(LocalDate localDate);

	public Vuelo findById(Long id);

	public List<Vuelo> findByDisponible(Boolean disponible);

	public Vuelo save(Vuelo vuelo);

	public void delete(Vuelo vuelo);

	public Boolean isUsed(Vuelo vuelo);

	public Vuelo MapNewToOld(Vuelo oldvuelo, Vuelo newvuelo);
	
	public Vuelo changeAvalibleByVueloId(Vuelo vuelo);

}