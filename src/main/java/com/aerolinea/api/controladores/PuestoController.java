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
import com.aerolinea.api.model.entity.Puesto;
import com.aerolinea.api.service.PuestoService;
import com.aerolinea.api.service.utils.constants.CommonWords;
import com.aerolinea.api.service.utils.constants.KeyResponse;
import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;

@RestController
@RequestMapping(path = "/puestos")
public class PuestoController extends ControllerGeneric<Puesto, PuestoService> {
	@Autowired
	private PuestoService puestoService;

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
	public ResponseEntity<?> guardar(@RequestBody @Valid Puesto puesto, BindingResult result, Locale locale) {
		String textToConcat = TablesAndAttributesName.PUESTOS_PUESTO + CommonWords.DOS_PUNTOS + puesto.getPuesto()
				+ CommonWords.ESPACIO + CommonWords.COMMA + TablesAndAttributesName.PUESTOS_TURNO
				+ CommonWords.DOS_PUNTOS + puesto.getTurno();
		return guardarEntity(puesto, result, textToConcat);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id, Locale locale) {
		return  eliminarEntity(id);
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
	public ResponseEntity<?> findByOne(@PathVariable Long id) {
		return findOne(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody @Valid Puesto puesto, BindingResult result,
			@PathVariable Long id) {
		String textToConcat = TablesAndAttributesName.PUESTOS_PUESTO + CommonWords.DOS_PUNTOS + puesto.getPuesto()
		+ CommonWords.ESPACIO + CommonWords.COMMA + TablesAndAttributesName.PUESTOS_TURNO
		+ CommonWords.DOS_PUNTOS + puesto.getTurno();
		return actualizarEntity(puesto, result, id, textToConcat);
	}
}
