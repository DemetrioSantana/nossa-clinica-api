package com.nossaclinica.api.tdo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class MedicalRecordTDO {
	
	private Long id;
	private String prescription;
	
}
