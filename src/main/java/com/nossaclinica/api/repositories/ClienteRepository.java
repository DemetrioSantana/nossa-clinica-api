package com.nossaclinica.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nossaclinica.api.models.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Optional<Cliente> findByCpf(String cpf);

}