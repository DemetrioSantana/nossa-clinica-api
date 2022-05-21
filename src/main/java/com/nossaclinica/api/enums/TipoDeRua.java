package com.nossaclinica.api.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoDeRua {

	AV(0, "AV"),
	BECO(1, "BECO"),
	RUA(2, "RUA"),
	SITIO(3, "SÍTIO"),
	TRAVESSA(4, "TRV");
	
	private Integer key;
	private String value;
		
}
