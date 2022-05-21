package com.nossaclinica.api.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Status {
	AGENDAR(0, "AGENDAR"),
	CANCELAR(1, "CANCELAR"),
	CONFIRMAR(2, "CONFIRMAR");
	
	private Integer id;
	private String descricao;	

}
