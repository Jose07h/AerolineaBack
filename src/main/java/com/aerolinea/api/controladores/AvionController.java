package com.aerolinea.api.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.api.controladores.generic.ControllerGeneric;
import com.aerolinea.api.model.entity.Avion;
import com.aerolinea.api.service.AvionService;
import com.aerolinea.api.service.utils.constants.KeyResponse;

@RestController
@RequestMapping(path = "/aviones")
public class AvionController extends ControllerGeneric<Avion, AvionService> {
 
	@Autowired
	private AvionService avionService;

	@Autowired
	private MessageSource mensajes;

	@GetMapping("/")
	public ResponseEntity<?> findAllData() {
		return findAll();
	}

	@GetMapping("/o/{orden}")
	public ResponseEntity<?> findByOrden(@PathVariable String orden) {
		return findAllByOrden(orden);
	}

	@PostMapping("/")
	public ResponseEntity<?> guardar(@RequestBody @Valid Avion avion, BindingResult result) {
		String textToConcat = avion.getModelo() ;
		return guardarEntity(avion, result, textToConcat);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return  eliminarEntity(id);
	}

	@GetMapping("/m/{modelo}")
	public ResponseEntity<?> findByModelo(@PathVariable String modelo, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Avion> avions = new ArrayList<Avion>();
		try {
			avions = avionService.findByModelo(modelo);
			if (avions.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, avions);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/d/{disponible}")
	public ResponseEntity<?> findByDisponible(@PathVariable Boolean disponible, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Avion> aviones = new ArrayList<Avion>();
		try {
			aviones = avionService.findByDisponible(disponible);
			if (aviones.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, aviones);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return findOne(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody @Valid Avion avion, BindingResult result,
			@PathVariable Long id) {
		String textToConcat = avion.getModelo();
		return actualizarEntity(avion, result, id, textToConcat);
	}
}
