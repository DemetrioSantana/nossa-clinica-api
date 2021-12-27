package com.nossaclinica.api.tdo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ContactTDO {
	
	private Long id;
	private String cellPhone;
	private String email;
	private Boolean isWhatsApp;

}
