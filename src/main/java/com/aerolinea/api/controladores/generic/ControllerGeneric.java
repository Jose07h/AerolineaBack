package com.aerolinea.api.controladores.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import com.aerolinea.api.service.generic.ServiceGeneric;
import com.aerolinea.api.service.utils.constants.CommonWords;
import com.aerolinea.api.service.utils.constants.KeyResponse;

public class ControllerGeneric<E, S> {

	
	private static final Logger log = LoggerFactory.getLogger(ControllerGeneric.class);

	@Autowired
	private ServiceGeneric<E> service;
	
	Locale locale =Locale.getDefault(); 

	@Autowired
	private MessageSource mensajes;

	public ResponseEntity<?> findOne(Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		E entity = null;
		try {
			entity = service.findById(id);
			if (entity == null) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			log.info(e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, entity);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<E> allDataList = new ArrayList<E>();
		try {
			allDataList = service.findAll();
			if (allDataList.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.datos", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			log.info(e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, allDataList);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> findAllByOrden(String orden) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<E> allDataList = new ArrayList<E>();
		try {
			allDataList = service.findAllByOrden(orden);
			if (allDataList.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.datos", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			log.info(e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, allDataList);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> guardarEntity(E entity, BindingResult result, String textConcatToMs) {
		Map<String, Object> response = new HashMap<String, Object>();
		E newEntity = null;
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put(KeyResponse.ERROR, errors);

			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.invalid.entity", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			newEntity = service.save(entity);
		} catch (DataAccessException e) {
			log.info(e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.MENSAJE,
				mensajes.getMessage("text.guardado", null, locale) + CommonWords.ESPACIO + textConcatToMs);
		response.put(KeyResponse.RESULT, newEntity);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> actualizarEntity(E entity, BindingResult result, Long id, String textConcatToMs) {
		Map<String, Object> response = new HashMap<String, Object>();
		E newEntity = null;
		E oldEntity = null;

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put(KeyResponse.ERROR, errors);
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.invalid.entity", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			oldEntity = service.findById(id);
			if (oldEntity == null) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			oldEntity = service.MapNewToOld(oldEntity, entity);
			newEntity = service.save(oldEntity);

		} catch (DataAccessException e) {
			 e.printStackTrace();
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.MENSAJE,
				mensajes.getMessage("text.actualizado", null, locale) + CommonWords.ESPACIO + textConcatToMs);
		response.put(KeyResponse.RESULT, newEntity);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> eliminarEntity(Long id) {
		E oldEntity = null;
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			oldEntity = service.findById(id);
			if (oldEntity == null) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			if (service.isUsed(oldEntity)) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.eliminar", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			service.delete(oldEntity);
		} catch (DataAccessException e) {
			log.info(e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.eliminado", null, locale));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
