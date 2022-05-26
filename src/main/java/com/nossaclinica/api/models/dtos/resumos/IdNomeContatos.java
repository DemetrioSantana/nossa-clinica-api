package com.nossaclinica.api.models.dtos.resumos;

import com.nossaclinica.api.models.dtos.ContatoDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IdNomeContatos {
	private Long id;
	private String nome;
	private ContatoDTO contato;

}
