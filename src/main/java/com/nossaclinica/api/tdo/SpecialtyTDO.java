package com.nossaclinica.api.tdo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SpecialtyTDO {

	private Long id;
	private String description;

}
