package com.nossaclinica.api.tdo;

import com.nossaclinica.api.enums.Permission;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserTDO {

	private Long id;
	private ContactTDO contatct;
	private String userName;
	private String password;
	private ProfileTDO profile;
	private Permission permission;
	private Boolean active;
	private Long fk;
	
	
}
