package com.nossaclinica.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nossaclinica.api.exceptionHandler.NegocioExcepiton;
import com.nossaclinica.api.models.entities.Contato;
import com.nossaclinica.api.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	
	public void verificarSeContatoEstaCadastrado(Contato contato) {
		Boolean campoEmUso = Boolean.FALSE;
		
		campoEmUso = repository.findByEmail(contato.getEmail())
				.stream().anyMatch(contatoCadastrado -> !contatoCadastrado.equals(contato));
		if (campoEmUso)
			throw new NegocioExcepiton("Já existe cadastro com esse email, favor informe outro!");
		
		campoEmUso = repository.findByCelular(contato.getCelular())
				.stream().anyMatch(contatoCadastrado -> !contatoCadastrado.equals(contato));
		if (campoEmUso)
			throw new NegocioExcepiton("Já existe cadastro com esse telefone, favor informe outro!");		
		
	}

}
