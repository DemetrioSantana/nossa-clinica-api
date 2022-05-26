package com.nossaclinica.api.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicos")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medico_id_seq")
	@SequenceGenerator(name = "medico_id_seq", sequenceName = "medico_id_seq", 
	initialValue = 1, allocationSize = 1)
	@Column(name = "id_medico")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "registro")
	private String registro;
	
	@OneToOne
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;
	
	
	@OneToMany
	@JoinTable(name = "medico_especialidade", 
	joinColumns = @JoinColumn(name = "medico_id", referencedColumnName = "id_medico"),
	inverseJoinColumns = @JoinColumn(name = "especialista_id", referencedColumnName = "id_especialidade"))
	private List<Especialidade> especialidades;

}
