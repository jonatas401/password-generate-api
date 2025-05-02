package com.beehome.desafio.application.usercase.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.beehome.desafio.domain.dto.GeneratePasswordForm;
import com.beehome.desafio.domain.entities.Vault;
import com.beehome.desafio.domain.repositories.GenerateRepository;
import com.beehome.desafio.interfaces.services.CreateServiceInterface;
import com.beehome.desafio.shared.utils.GeneratePasswordUtils;

@Service
public class CreateService implements CreateServiceInterface{
	private static final Logger LOGGER = LoggerFactory.getLogger(CreateService.class);
	
	private final GenerateRepository generateRepository;
	
	public CreateService(GenerateRepository generateRepository) {
		this.generateRepository = generateRepository;
	}

	@Override
	public String execute(GeneratePasswordForm generate) {
		LOGGER.info("Generating password");
		String string = GeneratePasswordUtils.generatePassword(generate);
		Vault vault = generateRepository.save(new Vault(string));
		return vault.getCreatedDate();
	}
	
}
