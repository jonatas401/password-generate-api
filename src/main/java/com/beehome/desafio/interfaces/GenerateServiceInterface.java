package com.beehome.desafio.interfaces;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.dto.GeneratePasswordForm;
import com.beehome.desafio.domain.dto.VaultDto;

public interface GenerateServiceInterface {

	
	public PagedModel<VaultDto> getAll(Pageable page, FilterParams filters);

	public String create(GeneratePasswordForm contato);
	
	public void delete(long id);
}
