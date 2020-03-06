package com.aerolinea.api.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.aerolinea.api.service.utils.constants.TablesName;

@Entity
@Table(name = TablesName.CATEGORIAS_VUELOS)
public class CategoriasVuelos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "La categoíra es reuerida")
	private String Categoria;
}
