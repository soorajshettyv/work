package com.ms.bootcamp.service;

import org.springframework.stereotype.Component;

import com.ms.bootcamp.model.ConversionFactorRequest;
import com.ms.bootcamp.model.ConversionFactorResponse;

@Component
public class ManageFactorFallBack implements CurrencyFactorMS {

	@Override
	public ConversionFactorResponse getConvertFactor(ConversionFactorRequest factor) {
		// TODO Auto-generated method stub
		return new ConversionFactorResponse(0.0) ;
	}

}
