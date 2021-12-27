package com.nossaclinica.api.converter.to_entity;

import com.nossaclinica.api.entities.Contact;
import com.nossaclinica.api.tdo.ContactTDO;

public class ConverterContactTDOToEntityContact {
	
	public Contact fromContactTDO(ContactTDO c) {
		Contact contact = new Contact();
		
		if (c.getId() != null) {

			contact.setId(c.getId());
		
		}
		
		contact.setCellPhone(c.getCellPhone());
		contact.setEmail(c.getEmail());
		contact.setIsWhatsApp(c.getIsWhatsApp());
		return contact;
	}

}
