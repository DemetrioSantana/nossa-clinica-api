package com.nossaclinica.api.converter.to_entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nossaclinica.api.entities.Attendance;
import com.nossaclinica.api.tdo.AttendanceTDO;

public class ConveterAttendaceTDOToEntityAttendance {
	
	@Autowired
	private ConveterClientTDOToEntityClient entityClient;
	
	@Autowired
	private ConverterMedicalRecordTDOToEntityMedicalRecord entityMedicalRecord;

	public List<Attendance> loadListAttendances(List<AttendanceTDO> atts) {
		List<Attendance> attendances = new ArrayList<Attendance>(); 

		if (!atts.isEmpty()) {
			atts.stream()
			.forEach(a -> {
			attendances.add(conveter(a));	
			});
		}
		return attendances;
	}

	public Attendance conveter(AttendanceTDO a) {
		Attendance attendance = new Attendance();
		
		if (a.getId() != null) {
			
			attendance.setId(a.getId());
			
		}
		
		attendance.setDate(a.getDate());
		attendance.setHour(a.getHour());
		
		attendance.setClient(entityClient.fromClientTDO(a.getClient()));
		attendance.setMedicalRecord(entityMedicalRecord.fromMedicalRecordTDO(a.getMedicalRecord()));
		return attendance;
	}

}
