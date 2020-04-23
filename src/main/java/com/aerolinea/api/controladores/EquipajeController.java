package com.aerolinea.api.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.aerolinea.api.model.entity.Equipaje;
import com.aerolinea.api.service.EquipajeService;

@RestController
@RequestMapping(path = "/equipaje")
public class EquipajeController extends ControllerGeneric<Equipaje, EquipajeService> {
	@Autowired
	private EquipajeService equipajeService;
	@GetMapping("/")
	public ResponseEntity<?> findAllData() {
		return findAll();
	}

	@GetMapping("/o/{orden}")
	public ResponseEntity<?> findByOrden(@PathVariable String orden) {
		return findAllByOrden(orden);
	}

	@PostMapping("/")
	public ResponseEntity<?> guardar(@RequestBody @Valid Equipaje equipaje, BindingResult result) {
		String textToConcat = equipaje.getId().toString();
		return guardarEntity(equipaje, result, textToConcat);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return eliminarEntity(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return findOne(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody @Valid Equipaje equipaje, BindingResult result,
			@PathVariable Long id) {
		String textToConcat = equipaje.getId().toString();
		return actualizarEntity(equipaje, result, id, textToConcat);
	}
	@GetMapping("/c/{id}")
	public List<Equipaje> findByClienteId(@PathVariable Long id){
		return equipajeService.findByClienteId(id);
	}
}
