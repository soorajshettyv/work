package com.ms.bootcamp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ms.bootcamp.exception.NODataFoundException;
import com.ms.bootcamp.model.MessageResponse;
import com.ms.bootcamp.entity.ProductDetails;
import com.ms.bootcamp.service.ProductService;
//import com.ms.bootcamp.jwt.JwtUtils;


@RestController
@RequestMapping("/productms")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class ProductCatalogueController {
Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ProductService productService;
	
	
	
	//Boolean isValid = false;
	
	private static final String SUCCESS_RESOURCECREATED_MESSAGE = "successfully added";
	private static final String SUCCESS_RESOURCEUPDATED_MESSAGE = "successfully updated";

	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/product") //create new Product
	public MessageResponse addProduct(@RequestBody ProductDetails product)
	{
		 productService.addProduct(product);
		return new MessageResponse(HttpStatus.CREATED.toString(), SUCCESS_RESOURCECREATED_MESSAGE,
				product);
	}
	
	@PutMapping("/product") //update existing product
	public ProductDetails updateProduct(@RequestBody ProductDetails product) throws NODataFoundException
	{
		return productService.updateProduct(product);
	
	}
	
	@GetMapping("/product") //List all products
	public List<ProductDetails> getProduct()
	{
		return productService.getProduct();
	
	}
	
	/*
	 * @GetMapping("/product/{name}") //List given product public ProductDetails
	 * getProductByName(@PathVariable String name) throws NODataFoundException {
	 * return productService.getProductByName(name);
	 * 
	 * }
	 */
	
	@GetMapping("/product/{id}") //List given product
	public  ProductDetails  getProductById(@PathVariable int id) throws NODataFoundException
	{
		log.info("----------getProductById----------"+id);
		System.out.println("id"+id);
		return productService.getProductById(id);
	
	}
	
	@DeleteMapping("/product/{name}")
	public void deleteProduct(@PathVariable String name) throws NODataFoundException
	{
		productService.deleteProduct(name);
	}
	
}
