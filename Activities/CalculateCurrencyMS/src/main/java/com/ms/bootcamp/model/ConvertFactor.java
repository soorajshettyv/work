package com.ms.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ConvertFactor")
public class ConvertFactor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "countryCode")
	private String countryCode;
	@Column(name = "conversionFactor")
	private Double conversionFactor;
	
	public ConvertFactor() {
		super();
	}
	
	public ConvertFactor(Integer id, String countryCode, Double conversionFactor) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}
	
	public ConvertFactor(String countryCode, Double conversionFactor) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
	
	
	
}
