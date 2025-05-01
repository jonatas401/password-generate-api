package com.beehome.desafio.shared.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.beehome.desafio.domain.dto.GeneratePasswordForm;

public class GeneratePasswordUtils {

	 	public static final String caracters = "!@#$%^&*()-_=+[]{}|;:,.<>?/";
	    public static final String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    public static final String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	    public static final String numbers = "0123456789";

		
		public static String generatePassword(GeneratePasswordForm generate) {
			StringBuilder password = new StringBuilder(generate.size());
			Random random = new SecureRandom();
			List<String> charSelected = new ArrayList<>();
			if(generate.isLower())	charSelected.add(lowerCaseLetters);
			if(generate.isUpper())	charSelected.add(upperCaseLetters);
			if(generate.numbers()) charSelected.add(numbers);
			if(generate.specialCharacter()) charSelected.add(caracters);
			
			for(int i = 0; i < generate.size();i++) {
				  String charCategory = i >= charSelected.size() ? charSelected.get(random.nextInt(charSelected.size())) : charSelected.get(i);
				  int position = random.nextInt(charCategory.length());
				  password.append(charCategory.charAt(position));
			}
			return password.toString();
		}
		
		
		public static List<String> shufleList(String pass) {
			List<String> letters = Arrays.asList(pass.split(""));
			Collections.shuffle(letters);
			return letters; 
		}
}
