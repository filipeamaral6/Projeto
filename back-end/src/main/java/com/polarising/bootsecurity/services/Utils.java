package com.polarising.bootsecurity.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Utils {
	
	public Utils() {
	}
	
	@Value("${app.vars.bankcode}")
	private int bankCode;
	
	/*
 * 		Format NIB: BBBB AAAA CCCC CCCC CCC KK
 * 		Format IBAN: CountryCode + NIB
 */	
	public String generateIban(String countryCode, int agency, Long accountNumber) {
		
		Long c = accountNumber;	
		int b = this.bankCode;
		int a = agency;
		int k = (int) (Math.random() * (99 - 0 + 1));

		return countryCode + b + a + c + k;
	}
}
