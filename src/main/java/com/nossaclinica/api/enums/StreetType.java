package com.nossaclinica.api.enums;

public enum StreetType {

	AV(1, "AV"),
	BECO(2, "BECO"),
	LOGRADOURO(3, "LOGRADOURO"),
	TRAVESSA(4, "TRAVESSA");
	
	private Integer key;
	private String value;
	
	private StreetType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public Integer getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	
	
}
