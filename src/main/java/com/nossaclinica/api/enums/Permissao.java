package com.nossaclinica.api.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Permissao {

	ADMINISTRADOR(0, "ADMINISTRADOR"),
	ATENDENTE(1, "ATENDENTE"),
	CLIENTE(2, "CLIENTE"),
	DOUTOR(3, "DOUTOR"),
	DEV(4, "DEV");
	
	private int kye;
	private String value;
	
}
