package com.krakedev.examen.vuelos.controllers;

import java.util.List;

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

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.services.ServicioVuelo;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

	// Inyeccion con constructor: 
	
	private final ServicioVuelo servicio;

	public VueloController(ServicioVuelo servicio) {
		this.servicio = servicio;
	}

	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Vuelo vuelo) {

		try {
			Vuelo nuevo = servicio.crear(vuelo);
			if (nuevo == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Error: código de vuelo ya existe o datos inválidos");
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear vuelo");
		}
	}


	@GetMapping
	public ResponseEntity<?> listar() {
		try {
			List<Vuelo> vuelos = servicio.listar();
			return ResponseEntity.ok(vuelos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar vuelos");
		}
	}

	// READ BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

		try {
			Vuelo vuelo = servicio.buscarPorId(id);
			if (vuelo == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vuelo no encontrado");
			}
			return ResponseEntity.ok(vuelo);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar vuelo");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Vuelo vuelo) {

		try {
			Vuelo actualizado = servicio.actualizar(id, vuelo);
			if (actualizado == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vuelo no encontrado o no se pudo actualizar");
			}
			return ResponseEntity.ok(actualizado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar vuelo");
		}
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		try {
			boolean eliminado = servicio.eliminar(id);
			if (!eliminado) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vuelo no encontrado");
			}
			return ResponseEntity.ok("Vuelo eliminado correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar vuelo");
		}
	}

	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable String codigo) {

		try {
			Vuelo vuelo = servicio.buscarPorCodigo(codigo);
			if (vuelo == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Vuelo no encontrado");
			}
			return ResponseEntity.ok(vuelo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error en la búsqueda por código");
		}
	}
}