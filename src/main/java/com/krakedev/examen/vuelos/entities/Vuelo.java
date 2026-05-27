package com.krakedev.examen.vuelos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vuelos")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 10)
	private String codigo;

	@Column(name = "precio_boleto", nullable = false)
	private double precioBoleto;

	@Column(name = "asientos_disponibles", nullable = false)
	private int asientosDisponibles;

	@Column(name = "destino", length = 100)
	private String destino;
	
	public Vuelo() {
	}

	public Vuelo(String codigo, double precioBoleto, int asientosDisponibles) {
		this.codigo = codigo;
		this.precioBoleto = precioBoleto;
		this.asientosDisponibles = asientosDisponibles;
	}

	public String getDestino() {
	    return destino;
	}

	public void setDestino(String destino) {
	    this.destino = destino;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPrecioBoleto() {
		return precioBoleto;
	}

	public void setPrecioBoleto(double precioBoleto) {
		this.precioBoleto = precioBoleto;
	}

	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(int asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", codigo=" + codigo + ", precioBoleto=" + precioBoleto + ", asientosDisponibles="
				+ asientosDisponibles + "]";
	}
}