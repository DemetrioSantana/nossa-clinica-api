package com.nossaclinica.api.models.summaries.tdos;

import java.io.Serializable;

import com.nossaclinica.api.enums.Permissao;
import com.nossaclinica.api.models.tdos.PerfilDTO;

import lombok.Data;

@Data
public class UserDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String userName;
	
	private Permissao permissao;
	
	private PerfilDTO perfil; 

}
