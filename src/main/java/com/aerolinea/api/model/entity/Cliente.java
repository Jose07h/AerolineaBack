package com.aerolinea.api.model.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.aerolinea.api.service.utils.constants.TablesName;

@Entity
@Table(name = TablesName.CIENTES)
public class Cliente implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "El nombre es requerido")
	private String nombre;
	
	@NotNull(message = "El apellido paterno es requerido")
	@Column(name = "ap_paterno")
	private String apPaterno;
	
	@Column(name = "ap_materno")
	private String apMaterno;
	
	@Max(value = 82,message = "La edad maxima es de 80 años")
	@NotNull(message = "La edad es requerida")
	private Integer edad;
	
	@NotNull(message = "El correo es requerido")
	@Email
	private String correo;
	private String sexo;
	@NotNull(message = "El numero de telefono es requerido")
	private Integer telefono;
	
	@Max(value = 120,message = "La edad maxima es de 120kg")
	@NotNull(message = "La peso es requerido")
	private Integer peso;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	private List<Equipaje> equpaje;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ReservasVuelo reservaVuelo;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public List<Equipaje> getEqupaje() {
		return equpaje;
	}

	public void setEqupaje(List<Equipaje> equpaje) {
		this.equpaje = equpaje;
	}
	
	

}
