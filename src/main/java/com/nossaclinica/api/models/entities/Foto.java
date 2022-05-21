package com.nossaclinica.api.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "fotos")*/
public class Foto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/*	@Id
	@EqualsAndHashCode.Include
	@Column(name = "id_foto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_foto_seq")*/
	private Long id;
	
//	@Column(name = "diretorio")
	private String path;
	
//	@Column(name = "titulo")
	private String titulo;
	
//	@Column(name = "descricao")
	private String descricao;
	
/*	@OneToMany
	@JoinColumn(name = "foto_id")*/
	private List<Foto> galeria = new ArrayList<Foto>();
	
}
