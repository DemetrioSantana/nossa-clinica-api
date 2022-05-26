package com.nossaclinica.api.setters;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.nossaclinica.api.models.dtos.ClienteDTO;
import com.nossaclinica.api.models.dtos.resumos.IdNomeContatos;

@Component
public class TipoDeRepresentacao {
	
	
	private HashMap<String, Class<?>> tipoDeRepresentacao;
	
	public HashMap<String, Class<?>> doCliente() {
		this.tipoDeRepresentacao = new HashMap<>();
		tipoDeRepresentacao.put("FULL_DATA", ClienteDTO.class);
		tipoDeRepresentacao.put("ID_NOME_CONTATO", IdNomeContatos.class);
		return tipoDeRepresentacao;
	}

}
