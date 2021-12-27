package com.nossaclinica.api.converter.to_entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.nossaclinica.api.entities.Client;
import com.nossaclinica.api.tdo.ClientTDO;

public class ConveterClientTDOToEntityClient {
	
	@Autowired
	private ConverterAddressTDOToEntityAddress entityAddress;
	
	@Autowired
	private ConverterContactTDOToEntityContact entityContact;
	
	public Client fromClientTDO(ClientTDO c) {
		Client client = new Client();
		
		if (c.getId() != null) {
			client.setId(c.getId());
		}
		
		client.setBirthDate(c.getBirthDate());
		client.setCpf(c.getCpf());
		client.setName(c.getName());
		client.setRg(c.getRg());
		client.setAddress(entityAddress.fromAddressTDO(c.getAddress()));
		client.setContact(entityContact.fromContactTDO(c.getContact()));
		return client;
	}


}
