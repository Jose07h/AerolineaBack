package com.aerolinea.api.model.entity;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;

@Entity
@Table(name = TablesAndAttributesName.EQUIPAJE)
public class Equipaje implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Digits(integer = 2,fraction = 2)
	@Max(value = 50,message = "El peso maximo permitido es 50kg")
	@Min(value = 1,message = "El peso minimo de es de 1kg")
	@NotNull(message = "El peso es requerido")
	private Integer peso;
	
	@NotNull(message = "La resistencia es requerida")
	@Max(value = 5,message = "La resistencia maxima es de 5")
	@Min(value = 1,message = "La resistencia minima es de 1")
	private Integer resistencia;
	
	@Digits(integer = 2,fraction = 2)
	@NotNull(message = "El alto del equipaje es requerido")
	@Max(value = 55,message = "El alto maximo es de 55cm")
	@Min(value = 10,message = "El alto  minimo es de 10cm")
	@Column(name = "alto_y")
	private Integer altoY;
	
	@Digits(integer = 2,fraction = 2)
	@Max(value = 30,message = "El ancho maximo es de 30cm")
	@Min(value = 10,message = "El ancho  minimo es de 10cm")
	@NotNull(message = "El ancho del equipaje es requerido")
	@Column(name = "ancho_z")
	private Integer anchoZ;
	
	@Digits(integer = 2,fraction = 2)
	@Max(value = 46,message = "El largo maximo es de 46cm")
	@Min(value = 10,message = "El largo  minimo es de 10cm")
	@NotNull(message = "El largo del equipaje es requerido")
	@Column(name = "largo_x")
	private Integer largoX;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getResistencia() {
		return resistencia;
	}

	public void setResistencia(Integer resistencia) {
		this.resistencia = resistencia;
	}

	public Integer getAltoY() {
		return altoY;
	}

	public void setAltoY(Integer altoY) {
		this.altoY = altoY;
	}

	public Integer getAnchoZ() {
		return anchoZ;
	}

	public void setAnchoZ(Integer anchoZ) {
		this.anchoZ = anchoZ;
	}

	public Integer getLargoX() {
		return largoX;
	}

	public void setLargoX(Integer largoX) {
		this.largoX = largoX;
	}

}
