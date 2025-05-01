package com.beehome.desafio.interfaces.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beehome.desafio.application.usercase.create.CreateService;
import com.beehome.desafio.domain.dto.GeneratePasswordForm;
import com.beehome.desafio.domain.entities.Vault;
import com.beehome.desafio.domain.repositories.GenerateRepository;


@ExtendWith(MockitoExtension.class)
class CreateServiceInterfaceTest {

	@Mock
	private GenerateRepository generateRepository;
	
	@Test
	@DisplayName("Check if the interface method was called")
	void checkIfCreatewithAllOptions() {
		GeneratePasswordForm generatePasswordForm = new GeneratePasswordForm(8, true, true, true,true);
		Vault vault = new Vault("password");
		CreateServiceInterface createServiceInterface = new CreateService(generateRepository);
		
		BDDMockito.given(generateRepository.save(Mockito.any(Vault.class))).willReturn(vault);
		String dateNow = createServiceInterface.execute(generatePasswordForm);
		
		assertNotNull(dateNow);
		assertEquals(vault.getCreatedDate().toString(), dateNow);
	}

}
