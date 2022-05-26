package com.nossaclinica.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nossaclinica.api.models.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
