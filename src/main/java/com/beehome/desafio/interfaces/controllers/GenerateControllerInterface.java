package com.beehome.desafio.interfaces.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.dto.GeneratePasswordForm;
import com.beehome.desafio.domain.dto.VaultDto;
import com.beehome.desafio.domain.exceptions.VaultNotFOundException;

import jakarta.validation.Valid;

@RequestMapping("/api")
public interface GenerateControllerInterface {

	@GetMapping("/password-history")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PagedModel<VaultDto>>  getAll(@PageableDefault(sort = "createdDate",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 10) Pageable page,
			@ModelAttribute FilterParams filters);
	
	@PostMapping("/generate-password")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> create(@RequestBody @Valid GeneratePasswordForm form) ;
	
	@DeleteMapping("/delete-password/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> delete(@PathVariable Long id) throws VaultNotFOundException ;
	
}
