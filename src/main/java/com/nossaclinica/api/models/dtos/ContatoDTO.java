package com.nossaclinica.api.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(Include.NON_NULL)
public class ContatoDTO {
	private String celular;
	private String email;
	private String instagram;
	private Boolean temWhatsApp;
}
