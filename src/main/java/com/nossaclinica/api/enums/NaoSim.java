package com.nossaclinica.api.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum NaoSim {
	N(0, false),
	S(1, true);
	
	private Integer id;
	private boolean value;

}
