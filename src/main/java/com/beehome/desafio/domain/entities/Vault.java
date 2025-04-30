package com.beehome.desafio.domain.entities;

import java.time.LocalDate;

import com.beehome.desafio.domain.dto.VaultDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vault {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String password;
	LocalDate createdDate;
	
	public Vault() {
	}
	public Vault(String passoword) {
		this.password = passoword;
		this.createdDate = LocalDate.now();
	}
	public Vault(VaultDto passwordDto) {
		this.password = passwordDto.password();
		this.createdDate = passwordDto.createdDate();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
