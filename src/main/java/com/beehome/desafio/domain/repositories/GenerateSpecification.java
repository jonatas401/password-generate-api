package com.beehome.desafio.domain.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.entities.Vault;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;

public class GenerateSpecification {

	 public static Specification<Vault> filter(FilterParams filters) {
	        return (root, query, criteriaBuilder) -> {
	        	ArrayList<Predicate> specs = new ArrayList<>();
	        	if(filters != null) {
	        		if(filters.createdDate() != null) {
	        			LocalDate createdDate = filters.createdDate();
			        	Expression<String> dataFormatada = criteriaBuilder.function(
			     	                "TO_CHAR", String.class, root.get("createdDate"), criteriaBuilder.literal("YYYY-MM-DD")
			     	            );
		
			     	    Predicate hasDate = criteriaBuilder.like(dataFormatada,String.format("%s%s%s","%",createdDate.toString(), "%" ) );
			     	    specs.add(hasDate);
	        		}
	        	}
	            
	     	   return criteriaBuilder.and(specs.toArray(new Predicate[0]));
	        };
	 }
}
