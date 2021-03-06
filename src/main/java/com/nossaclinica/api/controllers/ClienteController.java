package com.nossaclinica.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nossaclinica.api.models.tdos.ClienteDTO;
import com.nossaclinica.api.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired 
	private ClienteService service;
	
	@PostMapping(path = "/novo",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO cliente) {
		return service.criar(cliente);
	}
	
	@PutMapping()
	public ResponseEntity<Boolean> atualizar(@RequestBody ClienteDTO cliente) {
		return service.atualizar(cliente);
	}
	
	/**
	 * Faz consulta pelo ID ou pelo CPF ou RG ou pelo nome e data de nascimento ou cartão do SUS
	 */
	@GetMapping(path = "/do", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> buscarPor(@PathVariable Long id, 
			@PathVariable String cpf, @PathVariable String rg, @PathVariable String nome,
			@PathVariable LocalDate dataDeNascimento, @PathVariable String cartaoSUS) {
				return service.buscarPor(id, cpf, rg, nome, dataDeNascimento, cartaoSUS);
		
	}
	
	@GetMapping(path = "",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteDTO>> findAll(){
		return service.findAll();
	}
	
	
	@DeleteMapping
	public ResponseEntity<Boolean> remover(@PathVariable Long id){
		return service.remover(id);
	}

}
