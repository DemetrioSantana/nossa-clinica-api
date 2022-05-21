package com.nossaclinica.api.config.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nossaclinica.api.enums.TipoDeRua;

public class TipoDeRuaSerialize extends StdSerializer<TipoDeRua>{
	 
	private static final long serialVersionUID = -5510969442812856755L;
	
	public TipoDeRuaSerialize() {
		super(TipoDeRua.class);
	}

	@Override
	public void serialize(TipoDeRua value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		
		if (value != null)
			gen.writeString(value.getValue());
		else
			gen.writeNull();		
	}
}
