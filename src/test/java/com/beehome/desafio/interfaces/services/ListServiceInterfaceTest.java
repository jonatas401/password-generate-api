package com.beehome.desafio.interfaces.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedModel;

import com.beehome.desafio.application.usercase.list.ListService;
import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.dto.VaultDto;
import com.beehome.desafio.domain.entities.Vault;
import com.beehome.desafio.domain.repositories.GenerateRepository;


@ExtendWith(MockitoExtension.class)
class ListServiceInterfaceTest {

	@Mock
	private GenerateRepository generateRepository;
	
	@Test
	@DisplayName("check if vault list success")
	void checkIfListSuccess() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("createdDate"));
		FilterParams filterParams = new FilterParams(LocalDate.now());
		ListServiceInterface listService = new ListService(generateRepository);
		
		Vault vault = new Vault("123123");
		List<Vault> vaults = Arrays.asList(vault);
		PageImpl<Vault> pageImpl = new PageImpl<>(vaults,pageable,vaults.size());
		
		BDDMockito.given(this.generateRepository.findAll(Mockito.<Specification<Vault>>any(),Mockito.any(Pageable.class))).willReturn(pageImpl);
		PagedModel<VaultDto> vaultList = listService.execute(pageable, filterParams);
		List<VaultDto> content = vaultList.getContent();
		
		
		assertFalse(content.isEmpty());
        assertEquals(1, content.size());
        assertEquals("123123", content.get(0).password());
        assertEquals(LocalDate.now(), content.get(0).createdDate());
		
	}

}
