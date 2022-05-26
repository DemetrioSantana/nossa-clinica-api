package com.nossaclinica.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nossaclinica.api.models.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	Optional<Contato> findByEmail(String email);
	
	Optional<Contato> findByCelular(String celular);

}
