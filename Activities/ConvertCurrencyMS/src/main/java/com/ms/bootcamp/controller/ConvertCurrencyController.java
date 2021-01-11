package com.ms.bootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.bootcamp.model.ConversionFactorResponse;
import com.ms.bootcamp.service.CurrencyConvertService;

@RestController
@RequestMapping(path = "/convert")
public class ConvertCurrencyController {

	@Autowired
	CurrencyConvertService currecnyConvertService;
	
	
	
	@RequestMapping(path = "/currency/{CountryCode}/{amount}", method = RequestMethod.GET)
	public ResponseEntity<ConversionFactorResponse> getConvertedCurrency(@PathVariable String CountryCode, @PathVariable String amount) {
		try {
			double requestAmount = Double.parseDouble(amount);
			ConversionFactorResponse cFResponse = currecnyConvertService.getCurrencyConvertFactor(CountryCode);
			if (cFResponse.getConvertedAmount() == 0.0) {
				cFResponse.setConvertedAmount(0.0);
				return	new ResponseEntity<ConversionFactorResponse>(cFResponse,HttpStatus.FOUND);
			} else {
				Double factor = cFResponse.getConvertedAmount();
				Double convertedAmount = factor*requestAmount;
				cFResponse.setConvertedAmount(convertedAmount);
				return new ResponseEntity<ConversionFactorResponse>(cFResponse,HttpStatus.FOUND);
			}
			
		}catch (Exception e) {
			ConversionFactorResponse cfResponse = new ConversionFactorResponse(0.0);
			
			e.printStackTrace();
		  return new ResponseEntity<ConversionFactorResponse>(cfResponse,HttpStatus.FOUND);
		}
		
		
	}
	
}
