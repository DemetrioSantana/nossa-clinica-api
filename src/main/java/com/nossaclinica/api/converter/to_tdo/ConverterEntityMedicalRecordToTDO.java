package com.nossaclinica.api.converter.to_tdo;

import com.nossaclinica.api.entities.MedicalRecord;
import com.nossaclinica.api.tdo.MedicalRecordTDO;

public class ConverterEntityMedicalRecordToTDO {
	
	//CONVERTE DO TIPO MedicalRecord para MedicalRecordTDO
		public MedicalRecordTDO fromMedicalRecordToMedicalRecordTDO(MedicalRecord m) {
			
			if (m.getId() == null) {
				return null;
			}
			return MedicalRecordTDO.builder()
					.id(m.getId())
					.prescription(m.getPrescription())
					.build();
		}


}
