package com.aerolinea.api.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.aerolinea.api.service.utils.constants.TablesName;

@Entity
@Table(name = TablesName.PUESTOS)
public class Puesto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	@NotEmpty(message = "El puesto es requerido")
	private String puesto;

	
	@Column(nullable = false)
	@NotEmpty(message = "El turno es requerido")
	private String turno;

	@Column(nullable = false)
	@NotNull(message = "El salario es requerido")
	@Positive(message = "El salario tiene que ser mayor que 0")
	@Min(value = 1000,message = "EL salario deve de sermayor a 1000")
	private Integer salario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

}
