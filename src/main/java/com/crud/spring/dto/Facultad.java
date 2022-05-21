package com.crud.spring.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/** Se define como una entidad y se relaciona con una tabla llamada facultad */
@Entity
@Table(name = "facultad")

public class Facultad {

	/**
	 * Se define el campo ID y se mapea con el atributo código indicando que es la
	 * clave primaria de la entidad. El generationType indica la forma de
	 * incremento, si en el mysql viene definido como auto_incremental se definirá
	 * como incremental automático aquí.
	 */
	@Id
	@Column(name = "codigo")
	private Integer codigo;

	/**
	 * Se define que la columna nombre hace referencia al atributo nombre en la
	 * clase actual.
	 */
	@Column(name = "nombre")
	private String nombre;

	/**
	 * Relación de uno a muchos con la tabla investigadores, esta relación se
	 * realiza mediante la columna codigo (identificador de esta entidad).
	 */
	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Investigadores> investigadores;

	/**
	 * Relación de uno a muchos con la tabla equipos, esta relación se realiza
	 * mediante la columna codigo (identificador de esta entidad).
	 */
	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Equipos> equipos;

	/** Constructor vacío */
	public Facultad() {
	}

	/**
	 * Constructor con todos los atributos incluyendo las relaciones con las otras
	 * entidades.
	 * 
	 * @param codigo
	 * @param nombre
	 * @param investigadores
	 * @param equipos
	 */
	public Facultad(Integer codigo, String nombre, List<Investigadores> investigadores, List<Equipos> equipos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.investigadores = investigadores;
		this.equipos = equipos;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Mediante Json ignore eliminamos posibles bucles infinitos debido a la
	 * recursividad.
	 * 
	 * @return the investigadores
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigadores")
	public List<Investigadores> getInvestigadores() {
		return investigadores;
	}

	/**
	 * @param investigadores the investigadores to set
	 */
	public void setInvestigadores(List<Investigadores> investigadores) {
		this.investigadores = investigadores;
	}

	/**
	 * Mediante Json ignore eliminamos posibles bucles infinitos debido a la
	 * recursividad.
	 * 
	 * @return the equipos
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipos")
	public List<Equipos> getEquipos() {
		return equipos;
	}

	/**
	 * @param equipos the equipos to set
	 */
	public void setEquipos(List<Equipos> equipos) {
		this.equipos = equipos;
	}

}
