package com.course.algalogapi.domain.exception;

public class ClienteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ClienteException(String mensage) {
		super(mensage);
	}

}
