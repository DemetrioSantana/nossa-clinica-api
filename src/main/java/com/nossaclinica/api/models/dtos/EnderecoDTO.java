package com.nossaclinica.api.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter @Setter
public class EnderecoDTO {

	private String nomeCidade;
	private String bairro;
	private String logradouro;
	private String mumero;

}
