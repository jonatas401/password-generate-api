package com.beehome.desafio.application.usercase.create;

import org.springframework.stereotype.Service;

import com.beehome.desafio.domain.dto.GeneratePasswordForm;
import com.beehome.desafio.domain.entities.Vault;
import com.beehome.desafio.domain.repositories.GenerateRepository;
import com.beehome.desafio.interfaces.services.CreateServiceInterface;
import com.beehome.desafio.shared.utils.GeneratePasswordUtils;

@Service
public class CreateService implements CreateServiceInterface{
	
	private final GenerateRepository generateRepository;
	
	public CreateService(GenerateRepository generateRepository) {
		this.generateRepository = generateRepository;
	}

	@Override
	public String execute(GeneratePasswordForm generate) {
		String string = GeneratePasswordUtils.generatePassword(generate);
		Vault vault = generateRepository.save(new Vault(string));
		return vault.getCreatedDate().toString();
	}
	
}
