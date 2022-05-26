package com.nossaclinica.api.models.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "especialidades")
public class Especialidade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "especialidade_id_seq")
	@SequenceGenerator(sequenceName = "especialidade_id_seq", 
	name = "especialidade_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id_especialidade")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "valor_da_consulta", precision = 4, scale = 2)
	private BigDecimal valorDaConsulta;
	
}
