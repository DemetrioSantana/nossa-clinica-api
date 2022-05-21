package com.nossaclinica.api.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoServico {
	CIRURGIA(0, "CIRURGIA"),
	CONSULTA(1, "CONSULTA"),
	EXAME(2, "EXAME"),
	PACOTE(3, "PACOTE"),
	RETORNO(4, "RETORNO");
	
	private Integer id;
	private String descricao;
	
}
