package com.nossaclinica.api.models.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.nossaclinica.api.enums.MarcarDoComo;
import com.nossaclinica.api.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agendas")
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agenga_id_seq")
	@SequenceGenerator(sequenceName = "agenga_id_seq", 
	name = "agenga_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id_agenda")
	private Long idAgencia;
	
	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Column(name = "agendado_para")
	private LocalDate agendadoPara;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "marcado_como")
	@Enumerated(EnumType.STRING)
	private MarcarDoComo marcadoComo;

}
