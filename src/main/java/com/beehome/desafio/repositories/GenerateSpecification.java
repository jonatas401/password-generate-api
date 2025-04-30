package com.beehome.desafio.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.beehome.desafio.domain.entities.Vault;

import jakarta.persistence.criteria.Expression;

public class GenerateSpecification {

	 public static Specification<Vault> date(LocalDate createdDate) {
	        return (root, query, criteriaBuilder) -> {
	        	 Expression<String> dataFormatada = criteriaBuilder.function(
	     	                "TO_CHAR", String.class, root.get("createdDate"), criteriaBuilder.literal("YYYY-MM-DD")
	     	            );

	     	     return criteriaBuilder.like(dataFormatada, createdDate.toString() + "%");
	            
	        };
	 }
}
