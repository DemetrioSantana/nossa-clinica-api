package com.nossaclinica.api.converter.to_tdo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nossaclinica.api.entities.Attendance;
import com.nossaclinica.api.tdo.AttendanceTDO;

public class ConverterEntityAttendanceToAttedanceTDO {
	
	@Autowired
	private ConverterEntityMedicalRecordToTDO entityMedicalRecordToTDO;
	
	@Autowired
	private ConveterEntityClientToTDO entityClientToTDO;
	
	//CONVERTE DO TIPO Attendance para AttendanceTDO
		public AttendanceTDO fromAttendanceFromAttendanceTDO(Attendance a) {
			
			if (a.getId() == null) {
				return null;
			}
			
			return AttendanceTDO.builder()
					.id(a.getId())
					.client(entityClientToTDO.fromClientToClientTDO(a.getClient()))
					.date(a.getDate())
					.hour(a.getHour())
					.medicalRecord(entityMedicalRecordToTDO.fromMedicalRecordToMedicalRecordTDO(a.getMedicalRecord()))
					.build();
		}
		
		 //Carregar lista de atendimentos convetendo para uma lista de AttendanceTDOs
	    public List<AttendanceTDO> loadListAttendancesTDO(List<Attendance> attendances) {
			List<AttendanceTDO> listAttendancesTDOs = new ArrayList<AttendanceTDO>();
			
			if (!attendances.isEmpty()) {
				attendances.stream().forEach(a -> {

					listAttendancesTDOs.add(fromAttendanceFromAttendanceTDO(a));
					
				});
			}
			
			return listAttendancesTDOs;
		}
		
		

}
