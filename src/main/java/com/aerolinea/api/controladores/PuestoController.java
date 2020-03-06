package com.aerolinea.api.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.aerolinea.api.model.entity.Puesto;
import com.aerolinea.api.service.PuestoService;
import com.aerolinea.api.service.utils.constants.CommonWords;
import com.aerolinea.api.service.utils.constants.KeyResponse;

@RestController
@RequestMapping(path = "/puestos")
public class PuestoController {
	@Autowired
	private PuestoService puestoService;

	@Autowired
	private MessageSource mensajes;

	@GetMapping("/")
	public List<Puesto> findAll() {
		return puestoService.findAll();
	}

	@GetMapping("/o/{orden}")
	public List<Puesto> findByOrden(@PathVariable String orden) {
		return puestoService.findByOrden(orden);
	}

	@PostMapping("/")
	public ResponseEntity<?> guardar(@RequestBody @Valid Puesto puesto, BindingResult result, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		Puesto nuevoPuesto = null;
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put(KeyResponse.ERROR, errors);

			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.invalid.entity", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			nuevoPuesto = puestoService.save(puesto);
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.MENSAJE,
				mensajes.getMessage("text.guardado", null, locale) + CommonWords.ESPACIO + nuevoPuesto.getPuesto());
		response.put(KeyResponse.RESULT, nuevoPuesto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id, Locale locale) {
		Puesto oldPuesto = new Puesto();
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			oldPuesto = puestoService.findById(id);
			if (oldPuesto == null) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			if (puestoService.isUsedInEmpleados(oldPuesto)) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.eliminar", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			puestoService.delete(oldPuesto);
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.eliminado", null, locale));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/p/{puesto}")
	public ResponseEntity<?> findByPuesto(@PathVariable String puesto, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Puesto> puestos = new ArrayList<Puesto>();
		try {
			puestos = puestoService.findByPuesto(puesto);
			if (puestos.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, puestos);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/t/{turno}")
	public ResponseEntity<?> findByTurno(@PathVariable String turno, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Puesto> puestos = new ArrayList<Puesto>();
		try {
			puestos = puestoService.findByTurno(turno);
			if (puestos.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, puestos);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findByOne(@PathVariable Integer id, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		Puesto puesto = new Puesto();
		try {
			puesto = puestoService.findById(id);
			if (puesto == null) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, puesto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody @Valid Puesto puesto, BindingResult result,
			@PathVariable Integer id, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		Puesto nuevoPuesto = null;
		Puesto oldPuesto = null;

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put(KeyResponse.ERROR, errors);
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.invalid.entity", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			oldPuesto = puestoService.findById(id);
			if (oldPuesto == null) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			oldPuesto.setPuesto(puesto.getPuesto());
			oldPuesto.setTurno(puesto.getTurno());
			oldPuesto.setSalario(puesto.getSalario());
			nuevoPuesto = puestoService.save(oldPuesto);

		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.actualizado", null, locale)+CommonWords.ESPACIO+nuevoPuesto.getPuesto());
		response.put(KeyResponse.RESULT, nuevoPuesto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
