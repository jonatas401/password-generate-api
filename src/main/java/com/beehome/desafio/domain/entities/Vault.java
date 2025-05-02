package com.beehome.desafio.domain.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vault {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(nullable = false)
	String password;
	@Column(nullable = false)
	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy HH:mm")
	LocalDateTime createdDate;
	
	public Vault() {
	}
	public Vault(String passoword) {
		this.password = passoword;
		this.createdDate = LocalDateTime.now();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedDateTime() {
		return createdDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}
	
	public String getCreatedDate() {
		return createdDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
