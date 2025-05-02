package com.beehome.desafio.domain.exceptions;


public class VaultNotFOundException extends Exception{

	private static final long serialVersionUID = 1L;

	public VaultNotFOundException(Long id) {
		super(String.format("Password com id %s não encontrado", id));
	}
}
