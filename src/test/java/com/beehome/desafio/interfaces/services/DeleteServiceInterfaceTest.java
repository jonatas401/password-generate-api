package com.beehome.desafio.interfaces.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beehome.desafio.application.usercase.delete.DeleteService;
import com.beehome.desafio.domain.entities.Vault;
import com.beehome.desafio.domain.exceptions.VaultNotFoundException;
import com.beehome.desafio.domain.repositories.GenerateRepository;


@ExtendWith(MockitoExtension.class)
class DeleteServiceInterfaceTest {

	@Spy
	private GenerateRepository generateRepository;
	
	@Test
	@DisplayName("Check if delete password by id")
	void checkIfDeletePasswordById() throws VaultNotFoundException {
		Vault vault = new Vault("password");
		Long id = Long.valueOf(0);
		DeleteServiceInterface deleteServiceInterface = new DeleteService(generateRepository);
		
		when(this.generateRepository.findById(id)).thenReturn(Optional.of(vault));
		
		doNothing().when(generateRepository).delete(Mockito.any(Vault.class));
		deleteServiceInterface.execute(id);
		
		verify(generateRepository, times(1)).delete(vault);
	}
	
	@Test
	@DisplayName("Deveria retornar uma exceção")
	void shouldThrowVaultNotFoundContato() throws VaultNotFoundException{
		Long id = Long.valueOf(0);
		DeleteServiceInterface deleteServiceInterface = new DeleteService(generateRepository);
		
		BDDMockito.when(generateRepository.findById(id))
		.thenThrow(new VaultNotFoundException(id));
		
		
		assertThrows(VaultNotFoundException.class, ()-> deleteServiceInterface.execute(id));
	}

}
