package com.nossaclinica.api.config.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nossaclinica.api.enums.Status;

public class StatusConverter extends StdSerializer<Status>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected StatusConverter() {
		super(Status.class);
	}

	@Override
	public void serialize(Status value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		
		if (value != null) 
			gen.writeString(value.getDescricao());
		else
			gen.writeNull();

		
	}

}
