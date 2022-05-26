package com.nossaclinica.api.exceptionHandler;

public class NegocioExcepiton extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NegocioExcepiton(String msg) {
		super(msg);
	}

}
