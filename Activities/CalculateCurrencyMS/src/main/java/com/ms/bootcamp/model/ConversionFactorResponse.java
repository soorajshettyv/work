package com.ms.bootcamp.model;

public class ConversionFactorResponse {

	private Double convertedAmount;

	public ConversionFactorResponse() {
		super();
	
	}
	
	public ConversionFactorResponse(Double convertedAmount) {
		super();
		this.convertedAmount = convertedAmount;
	}

	@Override
	public String toString() {
		return "ConversionFactorResponse [convertedAmount=" + convertedAmount + "]";
	}

	public Double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	
	
	
}
