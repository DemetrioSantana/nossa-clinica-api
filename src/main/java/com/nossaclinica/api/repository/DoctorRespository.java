package com.nossaclinica.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nossaclinica.api.entities.Doctor;


@Repository
public interface DoctorRespository extends JpaRepository<Doctor, Long>{

	List<Doctor> findAll();

}
