package com.ms.bootcamp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.ms.bootcamp.model.ConvertFactor;

@Component
public interface CurrencyFactorRepository extends JpaRepository<ConvertFactor, Integer> {

	@Query("SELECT f FROM ConvertFactor f WHERE f.countryCode = :countryCode") 
	ConvertFactor findConvertFactorByCountryCode(String countryCode);
	
}
