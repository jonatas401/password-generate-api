package com.beehome.desafio.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record GeneratePasswordForm(
		@NotNull
		@Min(value = 8, message = "O tamanho deve ser no mínimo 8")
		Integer size,
		boolean isUpper,
		boolean isLower,
		boolean numbers,
		boolean specialCharacter
		) {
    
}
