package com.nossaclinica.api.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nossaclinica.api.enums.NaoSim;
import com.nossaclinica.api.enums.Permissao;
import com.nossaclinica.api.exceptionHandler.NegocioExcepiton;
import com.nossaclinica.api.models.dtos.ClienteDTO;
import com.nossaclinica.api.models.dtos.resumos.IdNomeContatos;
import com.nossaclinica.api.models.entities.Cliente;
import com.nossaclinica.api.models.entities.Usuario;
import com.nossaclinica.api.repositories.ClienteRepository;
import com.nossaclinica.api.setters.ClienteSetter;
import com.nossaclinica.api.setters.TipoDeRepresentacao;

@Service
@Component
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private ClienteSetter clienteSetter;
	
	@Autowired
	private TipoDeRepresentacao tiposDeRepresentacao;
	
	@Transactional
	public Cliente save(Cliente cliente) {
		Usuario usuario = null;
		
		verificarSeClienteEstaCadastrado(cliente);
		
		if (cliente.getUsuario() == null) 
			usuario = usuarioService.save(carregarUsuario(cliente));
		cliente.setUsuario(usuario);
			return repository.save(cliente);
	}



	@Transactional
	public Cliente update(Long id, Cliente cliente) {
		
		if (!repository.existsById(id))
			return null;
		cliente.setIdCliente(id);
		return repository.save(cliente);
	}

	
	public Optional<ClienteDTO> buscarPor(Long id, String cpf, String rg, String nome, LocalDate dataDeNascimento,
			String cartaoSUS) {
		return null;
			
	}
	
	public List<ClienteDTO> findAll() {
		return repository.findAll().stream()
		.map(this::converterToRepresentation)
		.collect(Collectors.toList());
	}

	
	@Transactional
	public Boolean remover(Long id) {
		repository.deleteById(id);
		return !repository.existsById(id);
	}
	
	public Optional<ClienteDTO> findById(Long id) {
		return repository.findById(id).map(this::converterToRepresentation);
		
	}


	private Class<?> getKey(String _class) {
		if (_class.equals("FULL_DATA"))
			return ClienteDTO.class;
		if (_class.equals("ID_NOME_CONTATO"))
			return IdNomeContatos.class;
		return null;
	}



	public boolean existsById(Long id) {
		return repository.existsById(id);
	}
	
	public ClienteDTO converterToRepresentation(Cliente cliente) {
		return clienteSetter.toDTO(cliente);			
	}

	private void verificarSeClienteEstaCadastrado(Cliente cliente) {
		Boolean clienteCadastrado = repository.findByCpf(cliente.getCpf())
				.stream().anyMatch(clienteEncontrado -> !clienteEncontrado.equals(cliente));
		if (clienteCadastrado) 
			throw new NegocioExcepiton("Já existe um cliente cadastrado com esse CPF!");
		
		contatoService.verificarSeContatoEstaCadastrado(cliente.getContato());
	}
	
	
	private Usuario carregarUsuario(Cliente cliente) {
		Usuario usuario = new Usuario();
		usuario.setCelular(cliente.getContato().getCelular());
		usuario.setEmail(cliente.getContato().getEmail());
		usuario.setUserName(cliente.getNome());
		usuario.setAtivo(NaoSim.S);
		usuario.setPermissao(Permissao.CLIENTE);
		return usuario;
	}

}
