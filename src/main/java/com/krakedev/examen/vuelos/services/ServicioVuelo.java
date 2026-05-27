package com.krakedev.examen.vuelos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.repositories.VueloRepository;

@Service
public class ServicioVuelo {

	private final VueloRepository repository;

	public ServicioVuelo(VueloRepository repository) {
		this.repository = repository;
	}

	public Vuelo crear(Vuelo vuelo) {
		return repository.save(vuelo);
	}

	public List<Vuelo> listar() {
		return repository.findAll();
	}


	public Vuelo buscarPorId(Long id) {
		Optional<Vuelo> resultado = repository.findById(id);
		return resultado.orElse(null);
	}

	public Vuelo actualizar(Long id, Vuelo vueloActualizado) {

		Vuelo vueloConsultado = buscarPorId(id);
		
		if (vueloConsultado == null) {
			return null;
		}

		vueloConsultado.setCodigo(vueloActualizado.getCodigo());
		vueloConsultado.setPrecioBoleto(vueloActualizado.getPrecioBoleto());
		vueloConsultado.setAsientosDisponibles(vueloActualizado.getAsientosDisponibles());

		return repository.save(vueloConsultado);
	}

	public boolean eliminar(Long id) {

		Vuelo vueloConsultado = buscarPorId(id);

		if (vueloConsultado == null) {
			return false;
		}

		repository.deleteById(id);
		return true;
	}

	public Vuelo buscarPorCodigo(String codigo) {
		return repository.findByCodigo(codigo);
	}
}