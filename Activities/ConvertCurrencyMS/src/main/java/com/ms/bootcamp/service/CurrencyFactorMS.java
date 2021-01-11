package com.ms.bootcamp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.bootcamp.model.ConversionFactorRequest;
import com.ms.bootcamp.model.ConversionFactorResponse;

@FeignClient(name= "currencyfactorms" , fallback = ManageFactorFallBack.class)
public interface CurrencyFactorMS {
	
	@RequestMapping(value = "/factor/getConversionFactor", method = RequestMethod.POST)
	public ConversionFactorResponse getConvertFactor(@RequestBody ConversionFactorRequest factor);

}
