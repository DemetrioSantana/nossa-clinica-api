package com.nossaclinica.api.models.tdos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter @Setter
public class ClienteDTO {
	
	private Long id;
	private EnderecoDTO endereco;

}
