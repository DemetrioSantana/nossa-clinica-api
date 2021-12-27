package com.nossaclinica.api.enums;

public enum Permission {

	ADMINISTRADOR(1, "ADMINISTRADOR"),
	ATENDENTE(2, "ATENDENTE"),
	CLIENTE(3, "CLINENTE"),
	DOUTOR(4, "DOUTOR");
	
	private Integer kye;
	private String value;

	Permission(Integer key, String value) {
		this.kye = key;
		this.value = value;
	}

	public Integer getKye() {
		return kye;
	}

	public String getValue() {
		return value;
	}
	
	
	
}
