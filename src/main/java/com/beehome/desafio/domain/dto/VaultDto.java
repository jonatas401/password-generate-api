package com.beehome.desafio.domain.dto;

import java.time.LocalDate;

import com.beehome.desafio.domain.entities.Vault;

public record VaultDto(String password, LocalDate createdDate) {

	public VaultDto(Vault vault){
		this(vault.getPassword(), vault.getCreatedDate());
	}
}
