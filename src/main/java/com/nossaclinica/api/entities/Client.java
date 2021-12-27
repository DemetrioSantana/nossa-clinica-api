package com.nossaclinica.api.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nossaclinica.api.enums.Permission;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends User {
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "rg")
	private String rg;
	
	
	@Column(name = "address")
	private Address address;
	
	
	

	public Client(Long id, Contact contatct, String userName, String nome, LocalDate birthDate, String password,
			Profile profile, Permission permission, Boolean active, Long fk, String cpf, String rg, Address address) {
		super(id, contatct, userName, nome, birthDate, password, profile, permission, active);
		this.cpf = cpf;
		this.rg = rg;
		this.address = address;
	}




	public Client() {
		super();
	}




		
}
