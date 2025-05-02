package com.beehome.desafio.application.usercase.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.dto.VaultDto;
import com.beehome.desafio.domain.entities.Vault;
import com.beehome.desafio.domain.repositories.GenerateRepository;
import com.beehome.desafio.domain.repositories.GenerateSpecification;
import com.beehome.desafio.interfaces.services.ListServiceInterface;

@Service
public class ListService implements ListServiceInterface{

	private static final Logger LOGGER = LoggerFactory.getLogger(ListService.class);
	
	private final GenerateRepository generateRepository;
	
	public ListService(GenerateRepository generateRepository) {
		this.generateRepository = generateRepository;
	}

	@Override
	public PagedModel<VaultDto> execute(Pageable page, FilterParams filters) {
		LOGGER.info("Listing voults ...");
		Specification<Vault> spec = GenerateSpecification.filter(filters);
		Page<Vault> vault = this.generateRepository.findAll(spec,page);
		return new PagedModel<VaultDto>(vault.map(VaultDto::new));
	}

}
