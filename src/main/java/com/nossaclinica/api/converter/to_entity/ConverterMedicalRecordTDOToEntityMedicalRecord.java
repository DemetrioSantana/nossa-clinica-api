package com.nossaclinica.api.converter.to_entity;

import com.nossaclinica.api.entities.MedicalRecord;
import com.nossaclinica.api.tdo.MedicalRecordTDO;

public class ConverterMedicalRecordTDOToEntityMedicalRecord {
	
public MedicalRecord fromMedicalRecordTDO(MedicalRecordTDO m) {
		
		MedicalRecord medicalRecord = new MedicalRecord();
		
		if (m.getId() != null) {
			
			medicalRecord.setId(m.getId());
			
		}
		
		medicalRecord.setPrescription(m.getPrescription());
		return medicalRecord;
	}


}
