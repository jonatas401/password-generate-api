package com.beehome.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beehome.desafio.domain.entities.Vault;

public interface GenerateRepository extends JpaRepository<Vault, Long>, JpaSpecificationExecutor<Vault>{

}
