package com.aerolinea.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aerolinea.api.model.entity.ReservasVuelo;
import com.aerolinea.api.model.entity.Vuelo;
import com.aerolinea.api.model.entity.CategoriasVuelos;
import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.repository.CategoriaRepository;
import com.aerolinea.api.model.repository.ClienteRepository;
import com.aerolinea.api.model.repository.ParametroRepository;
import com.aerolinea.api.model.repository.ReservasVueloRepository;
import com.aerolinea.api.model.repository.VuelosRepository;
import com.aerolinea.api.service.ReservaService;
import com.aerolinea.api.service.utils.constants.ParamKeys;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservasVueloRepository reservasVueloRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VuelosRepository vuelosRepository;

	@Autowired
	private ParametroRepository parametroRepository;

	@Override
	public List<ReservasVuelo> findAll() {
		return (List<ReservasVuelo>) reservasVueloRepository.findAll();
	}

	@Override
	public ReservasVuelo findById(Long id) {
		return reservasVueloRepository.findById(id).orElse(null);
	}

	@Override
	public ReservasVuelo save(ReservasVuelo reservasVuelo) {
		if (reservasVuelo.getId() == null||reservasVuelo.getOrigen()==null) {
			reservasVuelo.setOrigen(parametroRepository.findByKey(ParamKeys.CIUDAD_ORIGEN).getParametro());
		}
		return reservasVueloRepository.save(reservasVuelo);
	}

	@Override
	public void delete(ReservasVuelo reservasVuelo) {
		reservasVueloRepository.delete(reservasVuelo);
	}

	@Override
	public Boolean isUsed(ReservasVuelo reservasVuelo) {
		return false;
	}

	@Override
	public ReservasVuelo MapNewToOld(ReservasVuelo oldReservasVuelo, ReservasVuelo newReservasVuelo) {
		oldReservasVuelo.setNumeroAsiento(newReservasVuelo.getNumeroAsiento());
		oldReservasVuelo.setCategoria(newReservasVuelo.getCategoria());
		oldReservasVuelo.setCliente(newReservasVuelo.getCliente());
		oldReservasVuelo.setVuelo(newReservasVuelo.getVuelo());
		oldReservasVuelo.setPrecio(newReservasVuelo.getPrecio());
		oldReservasVuelo.setOrigen(newReservasVuelo.getOrigen());
		return oldReservasVuelo;
	}

	@Override
	public List<ReservasVuelo> findAllByOrden(String orden) {
		return null;
	}

	@Override
	public List<ReservasVuelo> findByNumeroAsiento(String numero) {
		return reservasVueloRepository.findByNumeroAsiento(numero);
	}

	@Override
	public List<ReservasVuelo> findByCategoria(CategoriasVuelos categoria) {
		return reservasVueloRepository.findByCategoria(categoria);
	}

	@Override
	public List<ReservasVuelo> findByCliente(Cliente cliente) {
		return reservasVueloRepository.findByCliente(cliente);
	}

	@Override
	public List<ReservasVuelo> findByVuelo(Vuelo vuelo) {
		return reservasVueloRepository.findByVuelo(vuelo);
	}

	public CategoriasVuelos findByCategoriaId(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	public Cliente findByClienteId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public Vuelo findByVueloId(Long id) {
		return vuelosRepository.findById(id).orElse(null);
	}

	@Override
	public ReservasVuelo findByidWithClienteWithVuelo(Long id) {
		return (ReservasVuelo) reservasVueloRepository.findByidWithClienteWithVuelo(id);
	}

	
}
