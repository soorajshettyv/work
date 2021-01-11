package com.ms.bootcamp.remoteservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.bootcamp.dto.ProductDTO;
import com.ms.bootcamp.model.MessageResponse;
import com.ms.bootcamp.model.ProductMessageRepsonse;
import com.ms.bootcamp.remoteservice.ProductMSFallBack;

@FeignClient(name= "productcataloguems" , fallback = ProductMSFallBack.class)
public interface ProductService {
	
	@PostMapping("/productms/product") //create new Product
	public ProductMessageRepsonse addProduct(@RequestHeader("Authorization") String authorizationToken,@RequestBody ProductDTO product);

        @PutMapping("/productms/product") //update existing product
	public ProductDTO updateProduct(@RequestHeader("Authorization") String authorizationToken,@RequestBody ProductDTO product) throws NODataFoundException;

        @GetMapping("/productms/product") //List all products
	public List<ProductDTO> getProduct(@RequestHeader("Authorization") String authorizationToken);

        @GetMapping("/productms/product/{id}") //List given product
	public  ProductDTO  getProductById(@RequestHeader("Authorization") String authorizationToken,@PathVariable int id) throws NODataFoundException;

        @DeleteMapping("/productms/product/{name}")
	public String deleteProduct(@RequestHeader("Authorization") String authorizationToken,@PathVariable String name) throws NODataFoundException;

}
