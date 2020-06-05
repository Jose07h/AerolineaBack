package com.aerolinea.api.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = TablesAndAttributesName.RESERVAS_VUELOS)
public class ReservasVuelo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotEmpty(message = "El numero de asiento es requerido")
	@Pattern(regexp = "^[A-J][0-9][0-9]$", message = "El numero de asiento tiene que inciar con una letra mayuscula "
			+ "desde la A asta la letra J y terminar con dos digostos Ejemplo A11 ")
	private String numeroAsiento;

	@ManyToOne
	@JoinColumn(name = "id_categoriavuelo", referencedColumnName = "id")
	private CategoriasVuelos categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@JsonBackReference(value = "cliente-reservas")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vuelo")
	@JsonIgnoreProperties(value={"reservasList", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	private Vuelo vuelo;
	
	@Column(precision = 16, scale = 2)
	private BigDecimal precio;
	
	private String origen;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}	

}
