package com.aerolinea.api.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reservas_vuelos")
public class ReservasVuelo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "reservaVuelo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cliente> clientesList;

	private String numeroAsiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoriavuelo", referencedColumnName = "id")
	private CategoriasVuelos categoria;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Cliente> getClientesList() {
		return clientesList;
	}

	public void setClientesList(List<Cliente> clientesList) {
		this.clientesList = clientesList;
	}

	public String getNumeroAsiento() {
		return numeroAsiento;
	}

	public void setNumeroAsiento(String numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}

	public CategoriasVuelos getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriasVuelos categoria) {
		this.categoria = categoria;
	}

}
