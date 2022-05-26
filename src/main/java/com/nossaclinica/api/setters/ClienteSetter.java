package com.nossaclinica.api.setters;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nossaclinica.api.models.dtos.ClienteDTO;
import com.nossaclinica.api.models.entities.Cliente;

@Component
public class ClienteSetter {
	
	@Autowired
	private ModelMapper modelMapper;

	public ClienteDTO toDTO(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDTO.class);
			
	}
	

	
	


}
