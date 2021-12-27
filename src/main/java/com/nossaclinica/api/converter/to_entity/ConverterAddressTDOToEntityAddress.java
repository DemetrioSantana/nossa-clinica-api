package com.nossaclinica.api.converter.to_entity;

import com.nossaclinica.api.entities.Address;
import com.nossaclinica.api.tdo.AddressTDO;

public class ConverterAddressTDOToEntityAddress {
	
	public Address fromAddressTDO(AddressTDO a) {
		Address address = new Address();

		if (a.getId() != null) {
			
			address.setId(a.getId());
			
		}
		
		address.setCity(a.getCity());
		address.setDistrict(a.getDistrict());
		address.setNumber(a.getNumber());
		address.setStreet(a.getStreet());
		address.setStreetType(a.getStreetType());
		address.setUf(a.getUf());
		address.setZipCode(a.getZipCode());
		return address;
	}

}
