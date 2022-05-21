package com.nossaclinica.api.models.tdos;


import com.nossaclinica.api.enums.NaoSim;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ContatoDTO {
	
	private Long id;
	private String celular;
	private String email;
	private String instagram;
	private NaoSim temWhatsApp;
	private NaoSim temTelegram;
}
