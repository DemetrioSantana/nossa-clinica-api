package com.nossaclinica.api.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nossaclinica.api.models.dtos.ClienteDTO;
import com.nossaclinica.api.models.entities.Cliente;
import com.nossaclinica.api.services.ClienteService;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired 
	private ClienteService service;
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente criar(@Valid @RequestBody Cliente cliente) {
		return service.save(cliente);
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		if (!service.existsById(id))
			ResponseEntity.notFound().build();
		
		cliente =  service.update(id, cliente);
		return ResponseEntity.ok(cliente);
	}
	
	/**
	 * Faz consulta pelo ID ou pelo CPF ou RG ou pelo nome e data de nascimento ou cartão do SUS
	 */
	@GetMapping(path = "/do", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> buscarPor(@PathVariable Long id, 
			@PathVariable String cpf, @PathVariable String rg, @PathVariable String nome,
			@PathVariable LocalDate dataDeNascimento, @PathVariable String cartaoSUS) {
		
		return null;/* service.buscarPor(id, cpf, rg, nome, dataDeNascimento, cartaoSUS)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.noContent().build());	*/	
	}
	
	@GetMapping(path = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {	
		return (ResponseEntity<ClienteDTO>) service.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<ClienteDTO> clientes = service.findAll();
		if (clientes.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(clientes);
		
	};
	
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Boolean remover(@PathVariable Long id){	
		return service.remover(id);
	}

}
