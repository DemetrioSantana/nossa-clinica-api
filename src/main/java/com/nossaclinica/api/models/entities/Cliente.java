package com.nossaclinica.api.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
			
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_id_seq")
	@SequenceGenerator(name = "cliente_id_seq",sequenceName = "cliente_id_seq", initialValue = 1, allocationSize = 1)
	private Long idCliente;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id")
	private Contato contato;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@NotBlank
	@Column(name = "nome")
	private String nome;
	
	@CPF
	@Column(name = "cpf", unique = true, length = 15)
	private String cpf;
	
	@Column(name = "rg", unique = true)
	private String rg;
	
	@Column(name = "emitido_por")
	private String orgaoEmissor;
	
	@Column(name = "nascido_em")
	private LocalDate dataDeNascimento;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public LocalDate getDataDeNascimento() {
		if (this.dataDeNascimento != null) 
			this.dataDeNascimento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		return this.dataDeNascimento;
	}
	
}
