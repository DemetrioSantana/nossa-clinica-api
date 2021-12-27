package com.nossaclinica.api.converter.to_entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.nossaclinica.api.entities.Doctor;
import com.nossaclinica.api.tdo.DoctorTDO;

public class ConveterDoctorTDOToEntityDoctor {
	
	@Autowired
	private ConveterAttendaceTDOToEntityAttendance entityAttendance;
	
	@Autowired
	private ConveterDayOfServiceTDOToEntityDayOfService entityDayOfService;
	
	
	   //CONVERTE DO TIPO DoctorTDO para Doctor
		public Doctor fromDoctorTDO(DoctorTDO doctorTDO) {
			Doctor doctor = new Doctor();
			doctor.setCrm(doctorTDO.getCrm());
			doctor.setName(doctorTDO.getName());
			doctor.setPrice(doctorTDO.getPrice());
			
			if (!doctorTDO.getAttendances().isEmpty()) {

				doctor.setAttendances(entityAttendance.loadListAttendances(doctorTDO.getAttendances()));
				
			}
			
			if (!doctorTDO.getDaysOfServie().isEmpty()) {

				doctor.setDaysOfServie(entityDayOfService.loadListDaysOfService(doctorTDO.getDaysOfServie()));
				
			}
					
			return doctor;
			
		}

}
