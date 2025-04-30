package com.beehome.desafio.presentation;

import java.net.URI;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.dto.GeneratePasswordForm;
import com.beehome.desafio.domain.dto.VaultDto;
import com.beehome.desafio.interfaces.GenerateControllerInterface;
import com.beehome.desafio.usercase.generate.GenerateServiceImpl;

@RestController
@RequestMapping("/api")
public class GenerateControllerImpl implements GenerateControllerInterface{
	
	private GenerateServiceImpl generateServiceImpl;

	public GenerateControllerImpl(GenerateServiceImpl generateServiceImpl) {
		this.generateServiceImpl = generateServiceImpl;
	}

	@Override
	public PagedModel<VaultDto> getAll(Pageable page, FilterParams filters) {
		return this.generateServiceImpl.getAll(page, filters);
	}

	@Override
	public ResponseEntity<String> create(GeneratePasswordForm form) {
		String pass = this.generateServiceImpl.create(form);
		URI uri = URI.create(String.format("https://localhost/api?nome=",pass));
		return ResponseEntity.created(uri).build();
	}

	@Override
	public void delete(long id) {
		this.generateServiceImpl.delete(id);
	}

}
