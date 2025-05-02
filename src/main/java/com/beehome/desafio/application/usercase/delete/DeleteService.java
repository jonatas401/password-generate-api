package com.beehome.desafio.application.usercase.delete;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.beehome.desafio.domain.entities.Vault;
import com.beehome.desafio.domain.exceptions.VaultNotFOundException;
import com.beehome.desafio.domain.repositories.GenerateRepository;
import com.beehome.desafio.interfaces.services.DeleteServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class DeleteService implements DeleteServiceInterface{
	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteService.class);
	
	private final GenerateRepository generateRepository;
	
	public DeleteService(GenerateRepository generateRepository) {
		this.generateRepository = generateRepository;
	}


	@Override
	@Transactional
	public void execute(Long id) throws VaultNotFOundException {
		LOGGER.info("Deleting password");
		Vault vault = generateRepository.findById(id).orElseThrow(()-> new VaultNotFOundException(id));
		this.generateRepository.delete(vault);
	}

}
