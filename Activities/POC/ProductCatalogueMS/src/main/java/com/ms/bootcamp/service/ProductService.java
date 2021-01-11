package com.ms.bootcamp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ms.bootcamp.exception.NODataFoundException;
import com.ms.bootcamp.entity.ProductDetails;
import com.ms.bootcamp.repository.ProductRepo;

@Service
@Component
@Transactional
public class ProductService {
	
		
		@Autowired
		ProductRepo repo;

		public void addProduct(ProductDetails product) {
			repo.save(product);
			
		}

		public ProductDetails updateProduct(ProductDetails product) throws NODataFoundException {
		Optional<ProductDetails> productOpt =	repo.findByProductname(product.getProductname());
		
		if(productOpt.isPresent())
		{	
			ProductDetails	productDetails = productOpt.get();
		productDetails.setPrice_per_unit(product.getPrice_per_unit());
		productDetails.setCategory(product.getCategory());
		productDetails.setInventory(product.getInventory());
		
			return repo.save(productDetails);
		}
		else
			throw new NODataFoundException("400", "Given product " +product.getProductname() +" details are not found. Please try again !!") ;

		}

		

		public List<ProductDetails> getProduct() {
			
			return repo.findAll();
		}

		public  ProductDetails  getProductByName(String name) throws NODataFoundException {
		
			Optional<ProductDetails> productOpt =	repo.findByProductname(name);
			
			if(productOpt.isPresent())
			{
				return productOpt.get();
			}
			else
				throw new NODataFoundException("400", "Given product " +name +" details are not found. Please try again !!") ;
			
		}

		public void deleteProduct(String name) throws NODataFoundException {
			ProductDetails product =	getProductByName(name);
			repo.delete(product);
			
		}

		public ProductDetails getProductById(int id) throws NODataFoundException 
		{
			Optional<ProductDetails> productDetailsOpt = repo.findById(id);
			if(productDetailsOpt.isPresent())
			{
				System.out.println(productDetailsOpt.get().getProductId()+productDetailsOpt.get().getProductname());
				return productDetailsOpt.get();
			}
			else
				throw new NODataFoundException("400", "Given product id " +id +" details are not found. Please try again !!") ;
	
				
		}
		

	

}

