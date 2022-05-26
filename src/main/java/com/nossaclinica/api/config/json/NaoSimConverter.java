package com.nossaclinica.api.config.json;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.nossaclinica.api.enums.NaoSim;

//@Converter(autoApply = true)
public class NaoSimConverter implements AttributeConverter<NaoSim, Integer>{

	@Override
	public Integer convertToDatabaseColumn(NaoSim attribute) {
		if (attribute != null)
			return attribute.getId() != null ? attribute.getId() : null;
		return NaoSim.N.getId();
	}

	@Override
	public NaoSim convertToEntityAttribute(Integer dbData) {
		if (dbData != null)
			for(NaoSim ns: NaoSim.values())
				if(ns.getId() == dbData)
					return ns;
		
		return NaoSim.N;
	}

	
}
