package com.nossaclinica.api.models.dtos.resumos;

import java.io.Serializable;

import lombok.Data;

@Data
public class IdNomeDescricao implements Serializable{
	 

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String descricao;

}
