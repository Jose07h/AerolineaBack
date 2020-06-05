package com.aerolinea.api.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.api.controladores.generic.ControllerGeneric;
import com.aerolinea.api.model.entity.CategoriasVuelos;
import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.entity.ReservasVuelo;
import com.aerolinea.api.model.entity.Vuelo;
import com.aerolinea.api.service.ReservaService;
import com.aerolinea.api.service.utils.constants.CommonWords;
import com.aerolinea.api.service.utils.constants.KeyResponse;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping(path = "/reserva")
public class ReservaController extends ControllerGeneric<ReservasVuelo, ReservaService> {
	@Autowired
	private ReservaService reservaService;

	@Autowired
	private MessageSource mensajes;

	@GetMapping("/")
	public ResponseEntity<?> findAllData() {
		return findAll();
	}

	@PostMapping("/")
	public ResponseEntity<?> guardar(@RequestBody ObjectNode objectNode, Locale locale) {
		return this.guardarReserva(objectNode, locale, null);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody ObjectNode objectNode, @PathVariable Long id, Locale locale) {
		return this.guardarReserva(objectNode, locale, id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id, Locale locale) {
		return eliminarEntity(id);
	}

	@GetMapping("/{by}/{id}")
	public ResponseEntity<?> findBy(@PathVariable String by, @PathVariable Long id, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<ReservasVuelo> reservas = new ArrayList<ReservasVuelo>();

		Boolean entityFound = false;
		String msResponse = mensajes.getMessage("text.no.encontrado", null, locale);

		try {
			switch (by.toLowerCase()) {
			case "cl":
				Cliente cliente = null;
				cliente = reservaService.findByClienteId(id);
				if (cliente == null) {
					msResponse = "Cliente " + msResponse;
					break;
				}
				entityFound = true;
				reservas = cliente.getReservasList();
				break;

			case "ct":
				CategoriasVuelos categoria = null;
				categoria = reservaService.findByCategoriaId(id);
				if (categoria == null) {
					msResponse = "Categoria " + msResponse;
					break;
				}
				entityFound = true;
				reservas = reservaService.findByCategoria(categoria);
				break;

			case "v":
				Vuelo vuelo = null;
				vuelo = reservaService.findByVueloId(id);
				if (vuelo == null) {
					msResponse = "Vuelo " + msResponse;
					break;
				}
				entityFound = true;
				reservas = vuelo.getReservasList();
				break;

			default:
				msResponse = "Link " + msResponse;
				break;
			}

			if (!entityFound) {
				response.put(KeyResponse.ERROR, msResponse);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			} else if (reservas.isEmpty() && entityFound) {
				response.put(KeyResponse.ERROR, "Reservas " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, reservas);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findByOne(@PathVariable Long id) {
		return findOne(id);
	}

	private ResponseEntity<?> guardarReserva(@RequestBody ObjectNode objectNode, Locale locale, Long idReserva) {
		ObjectMapper mapper = new ObjectMapper();
		// Se usa mapper para leer el JSON y converitrlo a los tipos deseados
		Long idCategoria = mapper.convertValue(objectNode.path("categoria"), Long.class);
		Long idCliente = mapper.convertValue(objectNode.path("cliente"), Long.class);
		Long idVuelo = mapper.convertValue(objectNode.path("vuelo"), Long.class);
		// Se obtine la instancia de reserva
		ReservasVuelo newReserva = mapper.convertValue(objectNode.path("reserva"), ReservasVuelo.class);
		Boolean isNew = idReserva == null ? true : false;

		ReservasVuelo oldReserva = null;
		List<String> erros = new ArrayList<String>();
		Map<String, Object> response = new HashMap<String, Object>();
		// Valida que los id exisan en la base
		try {
			CategoriasVuelos categoria = reservaService.findByCategoriaId(idCategoria);
			Cliente cliente = reservaService.findByClienteId(idCliente);
			Vuelo vuelo = reservaService.findByVueloId(idVuelo);
			if (!isNew) {
				oldReserva = reservaService.findById(idReserva);
				if (oldReserva == null) {
					response.put(KeyResponse.ERROR,
							"Reserva " + mensajes.getMessage("text.no.encontrado", null, locale));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
			}

			if (categoria == null) {
				response.put(KeyResponse.ERROR, "Categoria " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			if (cliente == null) {
				response.put(KeyResponse.ERROR, "Cliente " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			if (vuelo == null) {
				response.put(KeyResponse.ERROR, "Vuelo " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			// Se agrega relaciones ala reserva
			newReserva.setCategoria(categoria);
			newReserva.setCliente(cliente);
			newReserva.setVuelo(vuelo);
			newReserva.setPrecio(vuelo.getCosto().add(categoria.getCosto()));
			// Se intenta guardar la entidad en caso de encontrar error se obtiene la alista
			// de errores
			try {
				if (!isNew) {
					oldReserva = reservaService.MapNewToOld(oldReserva, newReserva);
					newReserva = reservaService.save(oldReserva);
				} else {
					newReserva = reservaService.save(newReserva);
				}
			} catch (ConstraintViolationException cve) {

				for (ConstraintViolation<?> constraintViolation : cve.getConstraintViolations()) {
					erros.add(constraintViolation.getMessage());
				}
				response.put(KeyResponse.ERROR, erros);
				response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.invalid.entity", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}

		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		String textToConcat = TablesAndAttributesName.RESERVAS_VUELOS + CommonWords.DOS_PUNTOS
				+ newReserva.getNumeroAsiento();
		response.put(KeyResponse.MENSAJE, isNew ? mensajes.getMessage("text.guardado", null, locale)
				: mensajes.getMessage("text.actualizado", null, locale) + CommonWords.ESPACIO + textToConcat);
		response.put(KeyResponse.RESULT, newReserva);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/{id}/ticket")
	public ResponseEntity<?> getDataForTicket(@PathVariable Long id, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		ReservasVuelo reserva = null;
		Cliente cliente = null;
		Vuelo vuelo = null;
		try {

			reserva = reservaService.findByidWithClienteWithVuelo(id);
			if (reserva == null) {
				response.put(KeyResponse.ERROR, "Reserva " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			cliente = reservaService.findByClienteId(reserva.getCliente().getId());
			vuelo = reservaService.findByVueloId(reserva.getVuelo().getId());

		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("reserva", reserva);
		response.put("cliente", cliente);
		response.put("vuelo", vuelo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
