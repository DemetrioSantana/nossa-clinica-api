package com.nossaclinica.api.config.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nossaclinica.api.enums.Permissao;

public class PermissaoSerialize extends StdSerializer<Permissao>{

	private static final long serialVersionUID = -7881662894927381967L;
	
	public PermissaoSerialize() {
		super(Permissao.class);
	}
	
	@Override
	public void serialize(Permissao value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		
		if(value != null) 
			gen.writeString(value.getValue());
		else
			gen.writeNull();		
	}
}
