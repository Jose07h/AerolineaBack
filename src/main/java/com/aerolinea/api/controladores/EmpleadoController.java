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
import com.aerolinea.api.model.entity.Empleado;
import com.aerolinea.api.model.entity.Puesto;
import com.aerolinea.api.service.EmpleadoService;
import com.aerolinea.api.service.PuestoService;
import com.aerolinea.api.service.utils.ValidateUtils;
import com.aerolinea.api.service.utils.constants.CommonWords;
import com.aerolinea.api.service.utils.constants.KeyResponse;

@RestController
@RequestMapping(path = "/empleados")
public class EmpleadoController extends ControllerGeneric<Empleado, EmpleadoService> {
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	PuestoService puestoService;

	@Autowired
	private MessageSource mensajes;

	@GetMapping("/")
	public ResponseEntity<?> findAllData() {
		return findAll();
	}

	@PostMapping("/")
	public ResponseEntity<?> guardar(@RequestBody @Valid Empleado empleado, BindingResult result, Locale locale) {
		String textToConcat = empleado.getNombre() + CommonWords.ESPACIO + empleado.getApPaterno();
		String correoDuplicado = "";
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			if (!ValidateUtils.isEmptyOrNull(empleado.getCorreo())) {
				correoDuplicado = empleadoService.findByCorreo(empleado.getCorreo()).isEmpty() ? ""
						: "El correo ya ha sido registrado";
				if (!correoDuplicado.isEmpty()) {
					response.put(KeyResponse.ERROR, correoDuplicado);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return guardarEntity(empleado, result, textToConcat);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id, Locale locale) {
		return eliminarEntity(id);
	}

	@GetMapping("/n/{nombre}")
	public ResponseEntity<?> findByNombre(@PathVariable String nombre, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			empleados = empleadoService.findByNombre(nombre);
			if (empleados.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, empleados);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/a/{apellido}")
	public ResponseEntity<?> findByApellido(@PathVariable String apellido, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			empleados = empleadoService.findByApPaterno(apellido);
			if (empleados.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, empleados);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/c/{correo}")
	public ResponseEntity<?> findByCorreo(@PathVariable String correo, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			empleados = empleadoService.findByCorreo(correo);
			if (empleados.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, empleados);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/d/{id}")
	public ResponseEntity<?> changeAvailable(@PathVariable Long id, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		Empleado empleado = null;
		try {
			empleado = empleadoService.changeAvalibleByEmpleadoId(id);
			if (empleado == null) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, empleado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findByOne(@PathVariable Long id) {
		return findOne(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody @Valid Empleado empleado, BindingResult result,
			@PathVariable Long id, Locale locale) {
		String correoDuplicado = "";
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			if (!ValidateUtils.isEmptyOrNull(empleado.getCorreo())) {
				List<Empleado> empleadoTemp = empleadoService.findByCorreo(empleado.getCorreo());
				if (!empleadoTemp.isEmpty())
					if (empleadoTemp.get(0).getId() != id)
						correoDuplicado = "El correo ya ha sido registrado";
				if (!correoDuplicado.isEmpty()) {
					response.put(KeyResponse.ERROR, correoDuplicado);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String textToConcat = empleado.getNombre() + CommonWords.ESPACIO + empleado.getApPaterno();
		return actualizarEntity(empleado, result, id, textToConcat);
	}

	@GetMapping("/{id}/{idPuesto}")
	public ResponseEntity<?> changePuesto(@PathVariable Long id, @PathVariable Long idPuesto, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		Empleado empleado = null;
		Puesto puesto = null;
		try {
			empleado = empleadoService.findById(id);
			if (empleado == null) {
				response.put(KeyResponse.ERROR, "Empleado " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			puesto = puestoService.findById(idPuesto);
			if (puesto == null) {
				response.put(KeyResponse.ERROR, "Puesto " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			empleado.setPuesto(puesto);
			empleado = empleadoService.save(empleado);
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, empleado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
