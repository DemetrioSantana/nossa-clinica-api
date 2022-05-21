package com.nossaclinica.api.config.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nossaclinica.api.enums.NaoSim;

public class NaoSimSerialize extends StdSerializer<NaoSim>{

	private static final long serialVersionUID = 1L;
	
	public NaoSimSerialize() {
		super(NaoSim.class);
	}


	@Override
	public void serialize(NaoSim value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		if (value != null) 
			gen.writeBoolean(value.isValue());
		else
			gen.writeNull();
	}
}
