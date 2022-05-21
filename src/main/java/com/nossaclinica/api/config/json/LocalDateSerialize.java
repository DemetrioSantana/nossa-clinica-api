package com.nossaclinica.api.config.json;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateSerialize extends StdSerializer<LocalDate>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4112411309799482430L;
	
	public LocalDateSerialize() {
		super(LocalDate.class);
	}

	@Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		if (value != null)
			gen.writeString(value.format(DateTimeFormatter.ISO_DATE));
		else 
			gen.writeNull();
	}

	
	
}
