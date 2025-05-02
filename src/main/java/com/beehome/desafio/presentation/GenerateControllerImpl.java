package com.beehome.desafio.presentation;

import java.net.URI;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.beehome.desafio.application.usercase.create.CreateService;
import com.beehome.desafio.application.usercase.delete.DeleteService;
import com.beehome.desafio.application.usercase.list.ListService;
import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.dto.GeneratePasswordForm;
import com.beehome.desafio.domain.dto.VaultDto;
import com.beehome.desafio.domain.exceptions.VaultNotFOundException;
import com.beehome.desafio.interfaces.controllers.GenerateControllerInterface;
import com.beehome.desafio.interfaces.services.CreateServiceInterface;
import com.beehome.desafio.interfaces.services.DeleteServiceInterface;
import com.beehome.desafio.interfaces.services.ListServiceInterface;

@RestController
public class GenerateControllerImpl implements GenerateControllerInterface{
	
	private final CreateServiceInterface createService;
	private final ListServiceInterface listService;
	private final DeleteServiceInterface deleteService;
	
	public GenerateControllerImpl(CreateService generateServiceImpl,
			ListService generateListService, DeleteService deleteService) {
		this.createService = generateServiceImpl;
		this.listService = generateListService;
		this.deleteService = deleteService;
	}

	@Override
	public ResponseEntity<PagedModel<VaultDto>> getAll(Pageable page, FilterParams filters) {
		return  ResponseEntity.ok(this.listService.execute(page, filters));
	}

	@Override
	public ResponseEntity<String> create(GeneratePasswordForm form) {
		String createdDate = this.createService.execute(form);
		URI uri = URI.create(String.format("http://localhost:8080/api/password-history?createdDate=%s",createdDate));
		return ResponseEntity.created(uri).build();
	}

	@Override
	public ResponseEntity<String> delete(Long id) throws VaultNotFOundException {
		deleteService.execute(id);
		return ResponseEntity.accepted().build();
	}

}
