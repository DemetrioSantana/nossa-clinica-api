package com.nossaclinica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nossaclinica.api.enums.Permission;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "contact_id")
	private Contact contact;
	
	@Column(name = "user_mane")
	private String userName;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne
	@JoinColumn(name = "profile")
	private Profile profile;
	
	@Column(name = "permission")
	@Enumerated(EnumType.ORDINAL)
	private Permission permission;
	
	@Column(name = "active")
	private Boolean active;
	
		
	public Boolean getIsActive() {
		if (this.active == null) {
			return this.active = Boolean.FALSE;
		}
		return this.active;
	}
	
}
