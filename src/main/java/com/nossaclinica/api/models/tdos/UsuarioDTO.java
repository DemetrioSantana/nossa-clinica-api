package com.nossaclinica.api.models.tdos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nossaclinica.api.enums.NaoSim;
import com.nossaclinica.api.enums.Permissao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private ContatoDTO contato;
	private String userName;
	private String senha;
	private String nome;
	private String cpf;
	private String rg;
	private String orgaoEmissor;
	private LocalDate dataDeNascimento;
	private PerfilDTO perfil;
	private Permissao permissao;
	private NaoSim ativo;	
	
}
