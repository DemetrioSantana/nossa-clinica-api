package com.nossaclinica.api.converter.to_tdo;

import com.nossaclinica.api.entities.Address;
import com.nossaclinica.api.tdo.AddressTDO;

public class ConverterEntityAddessToTDO {
	
	//CONVERTE DO TIPO Address para AddressTDO
	public AddressTDO fromAddessToAddressTDO(Address address) {
		
		if (address.getId() == null) {
			return null;
		}
		
		return AddressTDO.builder()
				.id(address.getId())
				.city(address.getCity())
				.district(address.getDistrict())
				.number(address.getNumber())
				.street(address.getStreet())
				.streetType(address.getStreetType())
				.uf(address.getUf())
				.zipCode(address.getZipCode())
				.build();
	}

}
