package com.beehome.desafio.interfaces.services;

import com.beehome.desafio.domain.exceptions.VaultNotFOundException;

public interface DeleteServiceInterface {

	public void execute(Long id) throws VaultNotFOundException;
}
