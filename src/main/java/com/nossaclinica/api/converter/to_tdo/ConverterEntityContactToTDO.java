package com.nossaclinica.api.converter.to_tdo;

import com.nossaclinica.api.entities.Contact;
import com.nossaclinica.api.tdo.ContactTDO;

public class ConverterEntityContactToTDO {
	
	//CONVERTE DO TIPO Contact para ContactTDO
		public ContactTDO fromContactToContactTDO(Contact contact) {
			
			if (contact.getIsWhatsApp() == null) {
				return null;
			}
			return ContactTDO.builder()
					.id(contact.getId())
					.cellPhone(contact.getCellPhone())
					.email(contact.getEmail())
					.isWhatsApp(contact.getIsWhatsApp())
					.build();
		}


}
