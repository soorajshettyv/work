package com.ms.bootcamp.remoteservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ms.bootcamp.dto.CartResponseDTO;
import com.ms.bootcamp.dto.ProductDTO;
import com.ms.bootcamp.model.MessageResponse;
import com.ms.bootcamp.model.ProductMessageRepsonse;

@Component
public class ProductMSFallBack implements ProductService {

	@Override
	public ProductMessageRepsonse addProduct(String token,ProductDTO product) {
		// TODO Auto-generated method stub
		return new ProductMessageRepsonse("Failed","productms not available for addProduct",product);
	}

	@Override
	public ProductDTO updateProduct(String token,ProductDTO product) throws NODataFoundException {
		// TODO Auto-generated method stub
		return new ProductDTO(0, "updateProduct NA", 0.0, "updateProduct NA", 0, "updateProduct NA");
	}

	@Override
	public List<ProductDTO> getProduct(String token) {
		// TODO Auto-generated method stub
		ProductDTO pDTO = new ProductDTO(0, "getProduct NA", 0.0, "getProduct NA", 0, "getProduct NA");
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		productList.add(pDTO);
		return productList;
	}

	@Override
	public ProductDTO getProductById(String token,int id) throws NODataFoundException {
		// TODO Auto-generated method stub
		return new ProductDTO(0, "getProductById NA", 0.0, "getProductById NA", 0, "getProductById NA");
	}

	@Override
	public String deleteProduct(String token,String name) throws NODataFoundException {
		// TODO Auto-generated method stub
		return "productms notavailable for deleteProduct";
	}

}
