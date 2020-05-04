package com.aerolinea.api.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = TablesAndAttributesName.VUELOS)
public class Vuelo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "La hora de salida es requerida")
	private LocalTime horaSalida;
	
	@NotNull(message = "La hora de llegada es requerida")
	private LocalTime horaLlegada;

	@NotNull(message = "El costo del vuelo es requerido")
	@Column(precision = 16, scale = 2)
	private BigDecimal costo;
	
	@NotNull(message = "La fecha del vuelo  es requerida ")
	private LocalDate fecha;
	
	private Integer reservados;
	
	private Boolean disponible;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_avion")
	@JsonBackReference(value = "vuelo-avion")
	private Avion avion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_destino", referencedColumnName = "id")
	private Destino destino;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "vuelo")
	@JsonManagedReference(value = "reservas-vuelo")
	private List<ReservasVuelo> reservasList;

	@ManyToMany
	@JoinTable(name = "personal_vuelo", joinColumns = @JoinColumn(name = "id_vuelo"), inverseJoinColumns = @JoinColumn(name = "id_empleado"))
	private List<Empleado> empleadosList;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getReservados() {
		return reservados;
	}

	public void setReservados(Integer reservados) {
		if (this.reservados==null ) {
			this.reservados=0;
		}
		this.reservados = reservados;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public List<ReservasVuelo> getReservasList() {
		return reservasList;
	}

	public void setReservasList(List<ReservasVuelo> reservasList) {
		this.reservasList = reservasList;
	}

	public List<Empleado> getEmpleadosList() {
		return empleadosList;
	}

	public void setEmpleadosList(List<Empleado> empleadosList) {
		this.empleadosList = empleadosList;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
	

}