package com.nossaclinica.api.models.entities;

import javax.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "datas_de_atendimento")
public class DataDeAtendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_de_atendimento_id_seq")
	@SequenceGenerator(sequenceName = "data_de_atendimento_id_seq", name = "data_de_atendimento_id_seq",
	allocationSize = 1, initialValue = 1)
	@Column(name = "id_data_atendimento")
	private Long id;
	
	@Column(name = "dia")
	private LocalDate dia;
	
	@Column(name = "a_partir_de")
	private LocalDateTime aPartirDe;
	
	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

}
