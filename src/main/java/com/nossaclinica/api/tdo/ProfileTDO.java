package com.nossaclinica.api.tdo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProfileTDO {
	
	private Long id;
	private String path;
}
