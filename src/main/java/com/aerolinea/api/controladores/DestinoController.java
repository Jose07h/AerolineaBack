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
import com.aerolinea.api.model.entity.Destino;
import com.aerolinea.api.service.DestinoService;
import com.aerolinea.api.service.utils.constants.CommonWords;
import com.aerolinea.api.service.utils.constants.KeyResponse;

@RestController
@RequestMapping(path = "/destinos")
public class DestinoController extends ControllerGeneric<Destino, DestinoService> {

	@Autowired
	private DestinoService destinoService;

	@Autowired
	private MessageSource mensajes;

	@GetMapping("/")
	public ResponseEntity<?> findAllData() {
		return findAll();
	}

	@GetMapping("/o/{orden}")
	public List<Destino> findByOrden(@PathVariable String orden) {
		return destinoService.findByOrden(orden);
	}

	@PostMapping("/")
	public ResponseEntity<?> guardar(@RequestBody @Valid Destino destino, BindingResult result) {
		String textToConcat = destino.getCiudad() + CommonWords.ESPACIO + destino.getPais();
		return guardarEntity(destino, result, textToConcat);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id, Locale locale) {
		return  eliminarEntity(id);
	}

	@GetMapping("/p/{pais}")
	public ResponseEntity<?> findByPais(@PathVariable String pais, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Destino> destinos = new ArrayList<Destino>();
		try {
			destinos = destinoService.findByPais(pais);
			if (destinos.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, destinos);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/c/{ciudad}")
	public ResponseEntity<?> findByCiudad(@PathVariable String ciudad, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Destino> destinos = new ArrayList<Destino>();
		try {
			destinos = destinoService.findByCiudad(ciudad);
			if (destinos.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, destinos);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id, Locale locale) {
		return findOne(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody @Valid Destino destino, BindingResult result,
			@PathVariable Integer id) {
		String textToConcat = destino.getCiudad() + CommonWords.ESPACIO + destino.getPais();
		return actualizarEntity(destino, result, id, textToConcat);
	}
}
