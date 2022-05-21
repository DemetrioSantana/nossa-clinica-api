package com.nossaclinica.api.models.tdos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CidadeDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	private Long id;

	private String nome;
	
	private String uf;
	
}
