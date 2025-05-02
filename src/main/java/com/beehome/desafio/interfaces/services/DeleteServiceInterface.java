package com.beehome.desafio.interfaces.services;

import com.beehome.desafio.domain.exceptions.VaultNotFoundException;

public interface DeleteServiceInterface {

	public void execute(Long id) throws VaultNotFoundException;
}
