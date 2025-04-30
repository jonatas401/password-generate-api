package com.beehome.desafio.usercase.generate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.dto.GeneratePasswordForm;
import com.beehome.desafio.domain.dto.VaultDto;
import com.beehome.desafio.domain.entities.Vault;
import com.beehome.desafio.interfaces.GenerateServiceInterface;
import com.beehome.desafio.repositories.GenerateRepository;
import com.beehome.desafio.repositories.GenerateSpecification;
import com.beehome.desafio.shared.utils.GeneratePasswordUtils;

@Service
public class GenerateServiceImpl implements GenerateServiceInterface{
	
	private final GenerateRepository generateRepository;
	
	public GenerateServiceImpl(GenerateRepository generateRepository) {
		this.generateRepository = generateRepository;
	}

	@Override
	public PagedModel<VaultDto> getAll(Pageable page, FilterParams filters) {
		Specification<Vault> spec = Specification.where(null);
		if(filters != null) {			
		 spec = GenerateSpecification.date(filters.createdDate());
		}
		Page<Vault> vault = this.generateRepository.findAll(spec,page);
		return new PagedModel<VaultDto>(vault.map(VaultDto::new));
	}

	@Override
	public String create(GeneratePasswordForm generate) {
		String string = GeneratePasswordUtils.generatePassword(generate);
		Vault vault = generateRepository.save(new Vault(string));
		return vault.getPassword();
	}

	@Override
	public void delete(long id) {
		generateRepository.deleteById(null);
	}
	
}
