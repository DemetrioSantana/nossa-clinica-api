package com.nossaclinica.api.tdo;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ClientTDO {
	
	private Long id;
	private String name;
	private String cpf;
	private String rg;
	private LocalDate birthDate;
	private AddressTDO address;
	private ContactTDO contact;

}
