package com.nossaclinica.api.models.dtos.resumos;

import java.io.Serializable;

import com.nossaclinica.api.enums.Permissao;
import com.nossaclinica.api.models.dtos.PerfilDTO;

import lombok.Data;

@Data
public class UsuarioDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String userName;
	
	private Permissao permissao;
	
	private PerfilDTO perfil; 

}
