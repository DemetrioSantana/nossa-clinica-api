package com.nossaclinica.api.tdo;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AttendanceTDO {
	
	private Long id;
	private ClientTDO client;

	private MedicalRecordTDO medicalRecord;
	private LocalDate date;
	private LocalDate hour;

}
