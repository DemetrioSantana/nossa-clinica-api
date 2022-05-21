package com.nossaclinica.api.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.nossaclinica.api.models.tdos.ClienteDTO;

@Service
@Component
public class ClienteService {
	
	public ResponseEntity<ClienteDTO> criar(ClienteDTO dto) {
		
		try{
			return ResponseEntity.created(null).body(dto);
		}catch (BadRequest e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}catch (Exception e) {	
			return ResponseEntity.internalServerError().build();
		}
	}


	public ResponseEntity<Boolean> atualizar(ClienteDTO cliente) {
		
		try{
			return ResponseEntity.ok(Boolean.TRUE);
		}catch (BadRequest e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}catch (Exception e) {	
			return ResponseEntity.internalServerError().build();
		}
	}

	
	public ResponseEntity<ClienteDTO> buscarPor(Long id, String cpf, String rg, String nome, LocalDate dataDeNascimento,
			String cartaoSUS) {
		ClienteDTO dto = null;
		try {
			return ResponseEntity.ok(dto);
		} catch (NoResultException e) {
			e.printStackTrace();
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	public ResponseEntity<List<ClienteDTO>> findAll() {
		try {
			return ResponseEntity.ok(new ArrayList<ClienteDTO>());
		} catch (NoResultException e) {
			e.printStackTrace();
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}


	public ResponseEntity<Boolean> remover(Long id) {
		try{
			return ResponseEntity.ok(Boolean.TRUE);
		}catch (BadRequest e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}catch (Exception e) {	
			return ResponseEntity.internalServerError().build();
		}
	}


}
