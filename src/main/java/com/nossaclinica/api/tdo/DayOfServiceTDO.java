package com.nossaclinica.api.tdo;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class DayOfServiceTDO {

	private Long id;
	
	private LocalDate date;
	
	private LocalDate time;
}
