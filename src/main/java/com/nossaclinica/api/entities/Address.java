package com.nossaclinica.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nossaclinica.api.enums.StreetType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "address")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "street_type")
	@Enumerated(EnumType.ORDINAL)
	private StreetType streetType;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "uf")
	private String uf;
	
	@Column(name = "district")
	private String district;

}
