package com.ms.bootcamp.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.ms.bootcamp.dto.CartDTO;
import com.ms.bootcamp.dto.ProductDTO;
//import com.ms.bootcamp.entity.CartEntity;
//import com.ms.bootcamp.remoteservice.NODataFoundException;

@FeignClient(name= "productcataloguems" , fallback = ProductMSFallBack.class)
public interface ProductMS {
	 @GetMapping("/productms/product/{id}") //List given product
		public  ProductDTO  getProductById(@RequestHeader("Authorization") String authorizationToken,@PathVariable int id) ;
}
