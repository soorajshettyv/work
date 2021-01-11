package com.ms.bootcamp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.ms.bootcamp.model.ConvertFactor;
import com.ms.bootcamp.repo.CurrencyFactorRepository;

@Service
@Component
public class CurrencyFactorService {

	
	@Autowired
	private CurrencyFactorRepository repo;
	
	public void saveFactor(ConvertFactor factor) {
		repo.save(factor);
	}

	public ConvertFactor getFactor(Integer id) {
		Optional<ConvertFactor> oFactor = repo.findById(id);
		if (oFactor.isPresent())
			return oFactor.get();
		else
			return null;
	}

	public ConvertFactor getFactorByCountry(String countryCode) {
		// TODO Auto-generated method stub
		return repo.findConvertFactorByCountryCode(countryCode);
	}

}
