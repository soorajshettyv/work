package com.ms.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.bootcamp.model.ConversionFactorResponse;
import com.ms.bootcamp.model.ConvertFactor;
import com.ms.bootcamp.service.CurrencyFactorService;

@RestController
@RequestMapping(path = "/factor")
public class CurrencyFactorController {

	@Autowired
	CurrencyFactorService currencyFactorService;
	
	
	@RequestMapping(path = "/addCurrency/{CountryCode}/{conversionRate}", method = RequestMethod.GET)
	public String addCurrencyConversionFactor(@PathVariable String CountryCode, @PathVariable String conversionRate) {
		try {
			ConvertFactor cf = currencyFactorService.getFactorByCountry(CountryCode);
			if(cf == null) {
				if(CountryCode != null && conversionRate != null) {
					double amt =Double.parseDouble(conversionRate);
					ConvertFactor currObj = new ConvertFactor(CountryCode, amt);
					currencyFactorService.saveFactor(currObj);
					return "{'Status': 'SUCCESS', 'Message': 'New Currency conversion factory created for Country code:"+CountryCode+"'}";
				} else {
					return "{'Status': 'FAILED', 'Message': 'Failed to add Currency conversion  for Country code:"+CountryCode+"'}";
				}
			}
			else
			{
				if(CountryCode != null && conversionRate != null) {
					double amt =Double.parseDouble(conversionRate);
					ConvertFactor currObj = new ConvertFactor(cf.getId(), CountryCode, amt);
					currencyFactorService.saveFactor(currObj);
					return "{'Status': 'SUCCESS', 'Message': 'Currency already exists and Updated Currency conversion factory for Country code:"+CountryCode+"'}";
				} else {
					return "{'Status': 'FAILED', 'Message': 'Currency already exists and Failed to update Currency conversion  for Country code:"+CountryCode+"'}";
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "{'Status': 'FAILED', 'Message': '"+e.getMessage()+"'}";			
		}

	}
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createConversionFactor(@RequestBody ConvertFactor convertFactor) {
		try {
			ConvertFactor cf = currencyFactorService.getFactorByCountry(convertFactor.getCountryCode());
			if(cf == null) {
				currencyFactorService.saveFactor(convertFactor);
				return "{'Status': 'SUCCESS', 'Message': 'New Currency conversion factory created for Country code:"+convertFactor.getCountryCode()+"'}";
			} else {
				return "{'Status': 'FAILED', 'Message': 'Currency conversion factor already exist for Country code:"+convertFactor.getCountryCode()+"'}";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "{'Status': 'FAILED', 'Message': '"+e.getMessage()+"'}";			
		}

	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String updateConversionFactor(@RequestBody ConvertFactor convertFactor) {
		try {
			ConvertFactor cf = currencyFactorService.getFactorByCountry(convertFactor.getCountryCode());
			if(cf != null) {
				convertFactor.setId(cf.getId());
				currencyFactorService.saveFactor(convertFactor);
				return "{'Status': 'SUCCESS', 'Message': 'Currency conversion factor updated for Country code:"+convertFactor.getCountryCode()+"'}";
			} else {
				return "{'Status': 'FAILED', 'Message': 'Currency conversion factor does not exist for Country code:"+convertFactor.getCountryCode()+"'}";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "{'Status': 'FAILED', 'Message': '"+e.getMessage()+"'}";			
		}

	}
	
	@RequestMapping(path = "/getConversionFactor", method = RequestMethod.POST)
	public ConversionFactorResponse getConversionFactor(@RequestBody ConvertFactor convertFactor) {
		ConvertFactor cf = currencyFactorService.getFactorByCountry(convertFactor.getCountryCode());
		ConversionFactorResponse cFResponse;
		if(cf != null) {
			cFResponse = new ConversionFactorResponse(cf.getConversionFactor());
			return cFResponse;
		} 
		return new ConversionFactorResponse(0.0);
	
    }
}
