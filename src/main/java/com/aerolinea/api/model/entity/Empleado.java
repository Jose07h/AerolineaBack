package com.aerolinea.api.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import com.aerolinea.api.service.utils.constants.TablesAndAttributesName;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = TablesAndAttributesName.EMPLEADOS)
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El nombre es requerido")
	private String nombre;

	@NotNull(message = "El apellido paterno es requerido")
	@Column(name = "ap_paterno")
	private String apPaterno;

	@Column(name = "ap_materno")
	private String apMaterno;

	@Max(value = 82, message = "La edad maxima es de 80 años")
	@Min(value = 18,message = "La edad minima es de 18")
	@NotNull(message = "La edad es requerida")
	private Integer edad;

	@NotEmpty(message = "El correo es requerido")
	@Email(message = "El Formato de correo no es valido")
	private String correo;

	@NotNull(message = "El sexo es requerido")
	private String sexo;

	@NotNull(message = "El numero de telefono es requerido")
	private Long telefono;
	
	@NotNull(message = "es estado de acupado es requrido")
	private Boolean ocupado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_puesto", referencedColumnName = "id")
	private Puesto puesto;
	 
	@JsonIgnore
	@ManyToMany(mappedBy = "empleadosList")
	private List<Vuelo> vueloList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public Boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}

	public List<Vuelo> getVueloList() {
		return vueloList;
	}

	public void setVueloList(List<Vuelo> vueloList) {
		this.vueloList = vueloList;
	}

}
