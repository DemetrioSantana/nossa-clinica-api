package com.nossaclinica.api.resources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nossaclinica.api.service.DoctorService;
import com.nossaclinica.api.tdo.DoctorTDO;


@RestController
@RequestMapping(value = "/doctors")
public class DoctorResource {
	
	@Autowired
	private DoctorService service;
	

	@PostMapping
	public ResponseEntity<DoctorTDO> save(@RequestBody DoctorTDO doctor) {
		return this.service.save(doctor);
	}
	

	@PutMapping
	public ResponseEntity<DoctorTDO> update(@RequestBody DoctorTDO doctor) {
		return this.service.update(doctor);
	}

	
	@GetMapping
	public ResponseEntity<List<DoctorTDO>> findAll(){
		return this.service.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DoctorTDO> findById(@PathParam("id") Long id) {
		return this.service.findById(id);
	}
	
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathParam("id") Long id) {
		return this.service.deleteById(id);
	}
	

}
