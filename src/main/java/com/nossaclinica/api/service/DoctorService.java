package com.nossaclinica.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nossaclinica.api.converter.to_entity.ConveterDoctorTDOToEntityDoctor;
import com.nossaclinica.api.converter.to_tdo.ConverterEntityDoctorToDoctorTDO;
import com.nossaclinica.api.entities.Doctor;
import com.nossaclinica.api.repository.DoctorRespository;
import com.nossaclinica.api.tdo.DoctorTDO;



@Service
@Component
public class DoctorService {
	
	@Autowired
	private DoctorRespository doctorRepository;
	
	@Autowired
	private ConverterEntityDoctorToDoctorTDO converterToDoctorTDO;
	
	@Autowired
	private ConveterDoctorTDOToEntityDoctor converterToEntityDoctor;
	

	
	public ResponseEntity<DoctorTDO> save(DoctorTDO doctorTDO) {
		
		Doctor doctor = converterToEntityDoctor.fromDoctorTDO(doctorTDO);
		
		return  ResponseEntity.created(null).body(this.converterToDoctorTDO.fromEntityDoctor(this.doctorRepository.save(doctor)));  
		
	}
	
	public ResponseEntity<DoctorTDO> update(DoctorTDO doctorTDO) {

		Doctor doctor = converterToEntityDoctor.fromDoctorTDO(doctorTDO);
		
		return  ResponseEntity.created(null).body(this.converterToDoctorTDO.fromEntityDoctor(this.doctorRepository.save(doctor)));
	}
	
	
	public ResponseEntity<List<DoctorTDO>> findAll() {
		
		return ResponseEntity.ok(this.converterToDoctorTDO.loadListDoctorTDO(this.doctorRepository.findAll()));
		
	}
	
	
	
	public ResponseEntity<DoctorTDO> findById(Long id) {
		
		return ResponseEntity.ok(this.converterToDoctorTDO.fromEntityDoctor(this.doctorRepository.findById(id).get()));
		
	}
	

	
	public ResponseEntity<?> deleteById(Long id) {
		
		if (this.doctorRepository.existsById(id)) {

			this.doctorRepository.deleteById(id);
			
			return ResponseEntity.noContent().build();
			
		}
		
		return ResponseEntity.notFound().build();
		
	}





}
