package com.beehome.desafio.domain.exceptions;


public class VaultNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VaultNotFoundException(Long id) {
		super(String.format("Password com id %s não encontrado", id));
	}
}
