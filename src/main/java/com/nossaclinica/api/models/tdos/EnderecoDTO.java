package com.nossaclinica.api.models.tdos;

import java.io.Serializable;

import com.nossaclinica.api.enums.TipoDeRua;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter @Setter
public class EnderecoDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private TipoDeRua tipoLogradouro;
	private String logradouro;
	private String numero;
	private String cep;
	private CidadeDTO cidade;
	private String bairro;

}
