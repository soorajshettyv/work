package com.ms.bootcamp.model;

public class ConversionFactorRequest {
	
	private String countryCode;

	public ConversionFactorRequest() {
		super();
	}

	public ConversionFactorRequest(String countryCode) {
		
		this.countryCode = countryCode;
	}

	public String toString() {
		return "ConversionFactorRequest[CountryCode:" + countryCode +"]";
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
}
