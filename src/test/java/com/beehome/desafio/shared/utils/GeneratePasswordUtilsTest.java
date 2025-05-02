package com.beehome.desafio.shared.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beehome.desafio.domain.dto.GeneratePasswordForm;

@ExtendWith(MockitoExtension.class)
class GeneratePasswordUtilsTest {

	@Test
	@DisplayName("check if generating password")
	void checkIfGeneratingPassowordWithAll() {
		GeneratePasswordForm generatePasswordForm = new GeneratePasswordForm(8,true,true,true,true);
		String password = GeneratePasswordUtils.generatePassword(generatePasswordForm);
		
		assertNotNull(password);
        assertEquals(8, password.length());
        assertTrue(password.matches(".*[a-z].*")); // lower
        assertTrue(password.matches(".*[A-Z].*")); // upper
        assertTrue(password.matches(".*\\d.*"));   // number
        assertTrue(password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"));
		
	}
	
	@Test
	@DisplayName("check if generating password lower")
	void checkIfGeneratingPassowordLower() {
		GeneratePasswordForm generatePasswordForm = new GeneratePasswordForm(8,false,true,false,false);
		String password = GeneratePasswordUtils.generatePassword(generatePasswordForm);
		
		assertNotNull(password);
        assertEquals(8, password.length());
        assertTrue(password.matches(".*[a-z].*")); // lower
        assertFalse(password.matches(".*[A-Z].*")); // upper
        assertFalse(password.matches(".*\\d.*"));   // number
        assertFalse(password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"));
		
	}
	
	@Test
	@DisplayName("check if generating password upper")
	void checkIfGeneratingPassowordUpper() {
		GeneratePasswordForm generatePasswordForm = new GeneratePasswordForm(8,true,false,false,false);
		String password = GeneratePasswordUtils.generatePassword(generatePasswordForm);
		
		assertNotNull(password);
        assertEquals(8, password.length());
        assertFalse(password.matches(".*[a-z].*")); // lower
        assertTrue(password.matches(".*[A-Z].*")); // upper
        assertFalse(password.matches(".*\\d.*"));   // number
        assertFalse(password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"));
		
	}
	
	@Test
	@DisplayName("check if generating password number")
	void checkIfGeneratingPassowordNumber() {
		GeneratePasswordForm generatePasswordForm = new GeneratePasswordForm(8,false,false,true,false);
		String password = GeneratePasswordUtils.generatePassword(generatePasswordForm);
		
		assertNotNull(password);
        assertEquals(8, password.length());
        assertFalse(password.matches(".*[a-z].*")); // lower
        assertFalse(password.matches(".*[A-Z].*")); // upper
        assertTrue(password.matches(".*\\d.*"));   // number
        assertFalse(password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"));
		
	}
	
	@Test
	@DisplayName("check if generating password Special caracter")
	void checkIfGeneratingPassowordSpecial() {
		GeneratePasswordForm generatePasswordForm = new GeneratePasswordForm(8,false,false,false,true);
		String password = GeneratePasswordUtils.generatePassword(generatePasswordForm);
		
		assertNotNull(password);
        assertEquals(8, password.length());
        assertFalse(password.matches(".*[a-z].*")); // lower
        assertFalse(password.matches(".*[A-Z].*")); // upper
        assertFalse(password.matches(".*\\d.*"));   // number
        assertTrue(password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"));
		
	}

}
