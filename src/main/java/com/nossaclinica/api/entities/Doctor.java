package com.nossaclinica.api.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nossaclinica.api.enums.Permission;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doutor")
public class Doctor extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "crm")
	private String crm;
	
	@OneToMany
	@JoinColumn(name = "specialties_id")
	private List<Specialty> specialties = new ArrayList<Specialty>();
	
	@JoinColumn(name = "picture_id")
	private Picture picture;
	
	
	@Column(name = "price")
	private String price;
	
	@OneToMany
	@JoinColumn(name = "attendance_id")
	private List<Attendance> attendances = new ArrayList<Attendance>();
	
	@OneToMany
	@JoinColumn(name = "day_of_service_id")
	private List<DayOfService> daysOfServie = new ArrayList<DayOfService>();

	public Doctor(Long id, Contact contatct, String userName, String nome, LocalDate birthDate, String password,
			Profile profile, Permission permission, Boolean active, String crm, List<Specialty> specialties,
			Picture picture, String price, List<Attendance> attendances, List<DayOfService> daysOfServie) {
		super(id, contatct, userName, nome, birthDate, password, profile, permission, active);
		this.crm = crm;
		this.specialties = specialties;
		this.picture = picture;
		this.price = price;
		this.attendances = attendances;
		this.daysOfServie = daysOfServie;
	}

	public Doctor() {
		super();
	}
	
	
	

}
