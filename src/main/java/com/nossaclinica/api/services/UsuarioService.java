package com.nossaclinica.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nossaclinica.api.models.entities.Usuario;
import com.nossaclinica.api.repositories.UsuarioRepository;
import com.nossaclinica.api.utils.FirstAndLastNameUtils;

@Service
@Component
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario save(Usuario usuario) {
		usuario.setUserName(getfirstAndLastName(usuario.getUserName()));
		if (usuario.getSenha() == null)
			usuario.setSenha(criarSenha());
		return repository.save(usuario);
	}
	
	private String criarSenha() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().substring(0, 6);
	}

	public Usuario update(Long id, Usuario usuario) {
		if (!repository.existsById(id))
			return null;
		usuario.setIdUsuario(id);
		return repository.save(usuario);
	}

	private String getfirstAndLastName(String userName) {
		FirstAndLastNameUtils nome = new FirstAndLastNameUtils();
		return nome.get(userName);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Optional<Usuario> findById(Long id) {
		return repository.findById(id);
	}
	
	public Boolean deleteById(Long id) {
		repository.deleteById(id);
		return !repository.existsById(id);
	}
	
	
	
}
