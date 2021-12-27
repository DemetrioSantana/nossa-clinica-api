package com.nossaclinica.api.converter.to_tdo;

import org.springframework.beans.factory.annotation.Autowired;

import com.nossaclinica.api.entities.Client;
import com.nossaclinica.api.tdo.ClientTDO;

public class ConveterEntityClientToTDO {
	
	@Autowired
	private ConverterEntityAddessToTDO entityAddressToTDO;
	
	@Autowired
	private ConverterEntityContactToTDO entityContactToTDO;
	
	//CONVERTE DO TIPO Client para ClientTDO
		public ClientTDO fromClientToClientTDO(Client client) {
			
			if (client.getId() == null) {
				return null;
			}
			
			return ClientTDO.builder()
					.id(client.getId())
					.address(entityAddressToTDO.fromAddessToAddressTDO(client.getAddress()))
					.birthDate(client.getBirthDate())
					.contact(entityContactToTDO.fromContactToContactTDO(client.getContact()))
					.cpf(client.getCpf())
					.name(client.getName())
					.rg(client.getRg())
					.build();
		}

}
