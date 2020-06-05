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
	private ClienteService clienteService;

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
			clientes = clienteService.findByNombre(nombre);
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
			clientes = clienteService.findByApMaterno(apMaterno);
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
			clientes = clienteService.findByApPaterno(apPaterno);
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
			clientes = clienteService.findByTelefono(telefono);
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
			clientes = clienteService.findByCorreo(correo);
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
			cliente = clienteService.findByEquipajeId(id);
			if (cliente == null) {
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

	@PostMapping("/e/{id}")
	public ResponseEntity<?> agregarEquipaje(@PathVariable Long id, @RequestBody @Valid Equipaje equipaje,
			BindingResult result, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		Cliente cliente = null;
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put(KeyResponse.ERROR, errors);
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.invalid.entity", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			cliente = clienteService.findById(id);
			if (cliente == null) {
				response.put(KeyResponse.ERROR, mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			cliente.getEqupaje().add(equipaje);
			clienteService.save(cliente);
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, cliente);
		response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.actualizado", null, locale));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/e/{id}/{idequipaje}")
	public ResponseEntity<?> actualizarEquipaje(@PathVariable Long id,
			@PathVariable(name = "idequipaje") Long idEquipaje, @RequestBody @Valid Equipaje equipaje,
			BindingResult result, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		Cliente cliente = null;
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put(KeyResponse.ERROR, errors);
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.invalid.entity", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			cliente = clienteService.findById(id);
			if (cliente == null) {
				response.put(KeyResponse.ERROR, "Cliente: " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}

			if (new ArrayList<>(
					cliente.getEqupaje().stream().filter(e -> e.getId() == idEquipaje).collect(Collectors.toList()))
							.isEmpty()) {
				response.put(KeyResponse.ERROR, "Equipaje: " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			cliente.getEqupaje().forEach(e -> {
				if (e.getId() == idEquipaje)
					clienteService.MapNewToOldEquipaje(e, equipaje);
			});
			clienteService.save(cliente);
		} catch (DataAccessException e) {
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, cliente);
		response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.actualizado", null, locale));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/e/{id}/{idequipaje}")
	public ResponseEntity<?> eliminarEquipaje(@PathVariable Long id, @PathVariable(name = "idequipaje") Long idEquipaje, Locale locale) {
		Map<String, Object> response = new HashMap<String, Object>();
		Cliente cliente = null;
		Equipaje equipaje=null;
		try {
			cliente = clienteService.findById(id);
			if (cliente == null) {
				response.put(KeyResponse.ERROR, "Cliente: " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			equipaje=cliente.getEqupaje().stream().filter(e->e.getId()==idEquipaje).findFirst().get();
			if (equipaje == null) {
				response.put(KeyResponse.ERROR, "Equipaje: " + mensajes.getMessage("text.no.encontrado", null, locale));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			clienteService.eliminarEquipaje(equipaje);
			 
		} catch (DataAccessException e) {
			e.printStackTrace();
			response.put(KeyResponse.ERROR, e.getMostSpecificCause().getMessage());
			response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.error", null, locale));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(KeyResponse.RESULT, cliente);
		response.put(KeyResponse.MENSAJE, mensajes.getMessage("text.eliminado", null, locale));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
