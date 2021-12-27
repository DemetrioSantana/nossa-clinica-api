package com.nossaclinica.api.converter.to_tdo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nossaclinica.api.entities.Attendance;
import com.nossaclinica.api.entities.Doctor;
import com.nossaclinica.api.tdo.AttendanceTDO;
import com.nossaclinica.api.tdo.DoctorTDO;

public class ConverterEntityDoctorToDoctorTDO {
	
	@Autowired
	private ConverterEntityAttendanceToAttedanceTDO entityAttendanceToTDO;
	
	@Autowired
	private ConverterEntityPictureToTDO entityPictureToTDO;
	
	//CONVERTE DO TIPO Doctor para DoctorTDO
    public DoctorTDO fromEntityDoctor(Doctor doctor) {
		
		return DoctorTDO.builder()
				.id(doctor.getId() != null ? doctor.getId() : null)
				.crm(doctor.getCrm())
				.name(doctor.getName())
				.attendances(loadListAttendancesTDO(doctor.getAttendances()))
				.picture(entityPictureToTDO.fromPictureToPictureTDO(doctor.getPicture()))
				.build();
	}
    
    //Carregar lista de atendimentos convetendo para uma lista de AttendanceTDOs
    private List<AttendanceTDO> loadListAttendancesTDO(List<Attendance> attendances) {
		List<AttendanceTDO> listAttendancesTDOs = new ArrayList<AttendanceTDO>();
		
		if (!attendances.isEmpty()) {
			
			entityAttendanceToTDO.loadListAttendancesTDO(attendances);
			
		}
		
		return listAttendancesTDOs;
	}

	public List<DoctorTDO> loadListDoctorTDO(List<Doctor> doctors) {
		List<DoctorTDO> listDoctors = new ArrayList<DoctorTDO>();
		
		if (!doctors.isEmpty()) {
			doctors.stream().forEach(doctor -> {
				listDoctors.add(fromEntityDoctor(doctor));
			});
		}
		return listDoctors;
	}

}
