package com.aerolinea.api.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aerolinea.api.model.entity.Destino;
import com.aerolinea.api.model.entity.Vuelo;
import com.aerolinea.api.model.repository.ReservasVueloRepository;
import com.aerolinea.api.model.repository.VuelosRepository;
import com.aerolinea.api.service.VueloService;

public class VueloServiceImpl implements VueloService {

	@Autowired
	private ReservasVueloRepository reservasVueloRepository;

	@Autowired
	private VuelosRepository vuelosRepository;

	@Override
	public List<Vuelo> findAllByOrden(String orden) {
		return null;
	}

	@Override
	public List<Vuelo> findAll() {
		return vuelosRepository.findAll();
	}

	@Override
	public List<Vuelo> findByDestinoCiudad(String ciudad) {
		return vuelosRepository.findByDestinoCiudad(ciudad);
	}

	@Override
	public List<Vuelo> findByDestinoPais(String pais) {
		return vuelosRepository.findByDestinoPais(pais);
	}

	@Override
	public List<Vuelo> findByDestino(Destino destino) {
		return vuelosRepository.findByDestino(destino);
	}

	@Override
	public List<Vuelo> findByFechaAndDestino(Destino destino, LocalDate date) {
		return vuelosRepository.findByFechaAndDestino(destino, date);
	}

	@Override
	public List<Vuelo> findByFecha(LocalDate localDate) {
		return findByFecha(localDate);
	}

	@Override
	public Vuelo findById(Long id) {
		return vuelosRepository.findById(id).orElse(null);
	}

	@Override
	public List<Vuelo> findByDisponible(Boolean disponible) {
		return findByDisponible(disponible);
	}

	@Override
	public Vuelo save(Vuelo vuelo) {
		return vuelosRepository.save(vuelo);
	}

	@Override
	public void delete(Vuelo vuelo) {
		vuelosRepository.delete(vuelo);
	}

	@Override
	public Boolean isUsed(Vuelo vuelo) {
		if (reservasVueloRepository.countByVueloId(vuelo.getId())>0) {
			return true;
		}
		return false;
	}

	@Override
	public Vuelo MapNewToOld(Vuelo oldvuelo, Vuelo newvuelo) {

		return null;
	}

	@Override
	public Vuelo changeAvalibleByVueloId(Long id) {

		return null;
	}

}
