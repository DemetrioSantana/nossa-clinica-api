package com.nossaclinica.api.models.summaries.tdos;

import java.io.Serializable;

import lombok.Data;

@Data
public class IdNomeDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	

}
