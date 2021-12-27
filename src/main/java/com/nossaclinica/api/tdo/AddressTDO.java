package com.nossaclinica.api.tdo;

import com.nossaclinica.api.enums.StreetType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class AddressTDO {
	
	private Long id;
	private StreetType streetType;
	private String street;
	private String number;
	private String zipCode;
	private String city;
	private String uf;
	private String district;

}
