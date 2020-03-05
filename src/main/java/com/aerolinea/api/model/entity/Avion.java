package com.aerolinea.api.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aviones")
public class Avion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String modelo;
	@Column(name = "cantidad_motores")
	private String cantidadMotores;
	@Column(name = "velosidad_maxima")
	private Integer velocidadMaxima;
	@Column(name = "cantidad_pasajeros")
	private Integer cantidadPasajeros;
	@Column(name = "peso_maximo")
	private Integer pesoMaximo;
	
	private Boolean disponible;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCantidadMotores() {
		return cantidadMotores;
	}

	public void setCantidadMotores(String cantidadMotores) {
		this.cantidadMotores = cantidadMotores;
	}

	public Integer getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(Integer velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public Integer getCantidadPasajeros() {
		return cantidadPasajeros;
	}

	public void setCantidadPasajeros(Integer cantidadPasajeros) {
		this.cantidadPasajeros = cantidadPasajeros;
	}

	public Integer getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(Integer pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

}
