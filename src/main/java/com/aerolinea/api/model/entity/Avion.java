package com.aerolinea.api.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;

@Entity
@Table(name = TablesAndAttributesName.AVIONES)
public class Avion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty(message = "El modelo es requerido")
	private String modelo;
	
	@NotNull(message = "La cantidad de motores deve de ser espesififcada")
	@Column(name = "cantidad_motores",nullable = false)
	@Positive(message = "La cantidad de motores deve de ser un numero positivo")
	@Min(value = 4,message = "La cantidad de mototres minima permititda son 4 motores")
	private Integer cantidadMotores;
	
	@NotNull(message = "La velocidad maxima es requerida")
	@Column(name = "velocidad_maxima",nullable = false)
	@Positive(message = "La velocidad deve de ser un numero positivo")
	@Max(value = 1040 ,message = "La velocidad maxima permitida es 1040 k/h")
	@Min(value = 500 ,message = "La velocidad minima permitida es 500 k/h")
	private Integer velocidadMaxima;
	
	@NotNull(message = "La cantidad maxima de pasajeros es requerida")
	@Column(name = "cantidad_pasajeros",nullable = false)
	@Positive(message = "La cantidad maxima de pasajeros deve de ser un numero positivo")
	@Min(value = 15,message = "El minimo de pasajeros admitido es 15 pasajeros por avion")
	private Integer cantidadPasajeros;
	
	@NotNull(message = "El peso maximo que puede soportar el avion es requerido")
	@Column(name = "peso_maximo",nullable = false)
	private Integer pesoMaximo;
	
	@Column(nullable = false)
	@NotNull(message = "La disponibilidad es requerida")
	private Boolean disponible;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getCantidadMotores() {
		return cantidadMotores;
	}

	public void setCantidadMotores(Integer cantidadMotores) {
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
