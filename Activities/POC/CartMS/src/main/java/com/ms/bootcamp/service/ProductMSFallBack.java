package com.ms.bootcamp.service;


import org.springframework.stereotype.Component;

import com.ms.bootcamp.dto.ProductDTO;

@Component
public class ProductMSFallBack implements ProductMS {

	@Override
	public ProductDTO getProductById(String authorizationToken, int id) {
		 return new ProductDTO(0, "getProductById NA", 0.0, "getProductById NA", 0, "getProductById NA");
		
	}

}
