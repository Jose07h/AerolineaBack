package com.aerolinea.api.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;

@Entity
@Table(name = TablesAndAttributesName.DESTINOS)
public class Destino implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	@NotEmpty(message = "La ciudad es requerida")
	private String ciudad;
	
	@Column(nullable = false)
	@NotEmpty(message = "El pais es requerido")
	private String pais;
	
	@Column(nullable = false)
	@NotNull(message = "Es nesesario espesificar la disponobilidad del destino")
	private Boolean disponible;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
	

}
