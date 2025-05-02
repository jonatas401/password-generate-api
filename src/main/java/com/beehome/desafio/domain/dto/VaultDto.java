package com.beehome.desafio.domain.dto;

import com.beehome.desafio.domain.entities.Vault;

public record VaultDto(String password, String createdDate, Long id) {

	public VaultDto(Vault vault){
		this(vault.getPassword(), vault.getCreatedDateTime(), vault.getId());
	}
}
