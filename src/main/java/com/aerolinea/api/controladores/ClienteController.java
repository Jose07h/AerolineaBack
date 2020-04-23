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
import com.aerolinea.api.model.entity.Cliente;
import com.aerolinea.api.model.entity.Equipaje;
import com.aerolinea.api.service.ClienteService;
import com.aerolinea.api.service.utils.constants.CommonWords;
import com.aerolinea.api.service.utils.constants.KeyResponse;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController extends ControllerGeneric<Cliente, ClienteService> {

	@Autowired
	private ClienteService ClienteService;

	@Autowired
	private MessageSource mensajes;

	@GetMapping("/")
	public ResponseEntity<?> findAllData() {
		return findAll();
	}

	@PostMapping("/")
	public ResponseEntity<?> guardar(@RequestBody @Valid Cliente cliente, BindingResult result) {
		String textToConcat = cliente.getNombre() + CommonWords.ESPACIO + cliente.getApPaterno();
		return guardarEntity(cliente, result, textToConcat);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return eliminarEntity(id);
	}

	@GetMapping("/n/{nombre}")
	public ResponseEntity<?> findByNombre(@PathVariable String nombre, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			clientes = ClienteService.findByNombre(nombre);
			if (clientes.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, clientes);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/m/{apmaterno}")
	public ResponseEntity<?> findByApMaterno(@PathVariable(name = "apmaterno") String apMaterno, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			clientes = ClienteService.findByApMaterno(apMaterno);
			if (clientes.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, clientes);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/p/{appaterno}")
	public ResponseEntity<?> findByApPaterno(@PathVariable(name = "appaterno") String apPaterno, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			clientes = ClienteService.findByApPaterno(apPaterno);
			if (clientes.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, clientes);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/t/{telefono}")
	public ResponseEntity<?> findByTelefono(@PathVariable Integer telefono, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			clientes = ClienteService.findByTelefono(telefono);
			if (clientes.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, clientes);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/c/{correo}")
	public ResponseEntity<?> findByCorreo(@PathVariable String correo, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			clientes = ClienteService.findByCorreo(correo);
			if (clientes.isEmpty()) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, clientes);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/e/{id}")
	public ResponseEntity<?> findByEquipajeId(@PathVariable Long id, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		
		Cliente cliente = null;
		try {
			cliente = ClienteService.findByEquipajeId(id);
			if (cliente==null) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, cliente);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
 
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return findOne(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody @Valid Cliente cliente, BindingResult result,
			@PathVariable Long id) {
		String textToConcat = cliente.getNombre() + CommonWords.ESPACIO + cliente.getApPaterno();
		return actualizarEntity(cliente, result, id, textToConcat);
	}
}
