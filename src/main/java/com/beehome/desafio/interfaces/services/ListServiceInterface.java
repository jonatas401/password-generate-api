package com.beehome.desafio.interfaces.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.dto.VaultDto;

public interface ListServiceInterface {

	public PagedModel<VaultDto> execute(Pageable page, FilterParams filters);
}
