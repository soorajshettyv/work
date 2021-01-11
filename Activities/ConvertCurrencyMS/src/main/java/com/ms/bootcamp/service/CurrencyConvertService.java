package com.ms.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ms.bootcamp.model.ConversionFactorRequest;
import com.ms.bootcamp.model.ConversionFactorResponse;

@Service
@Component
public class CurrencyConvertService {

	@Autowired
	CurrencyFactorMS currencyFactorMS;
	
	public ConversionFactorResponse getCurrencyConvertFactor(String CountryCode) {
		// TODO Auto-generated method stub
		ConversionFactorRequest newRequest = new ConversionFactorRequest(CountryCode);
		ConversionFactorResponse convertfactorResponse = currencyFactorMS.getConvertFactor(newRequest);
		return convertfactorResponse;
		
	}

}
