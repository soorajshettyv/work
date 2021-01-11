package com.ms.bootcamp.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.bootcamp.entity.CartEntity;

//import com.ms.bootcamp.model.ConversionFactorRequest;
//import com.ms.bootcamp.model.ConversionFactorResponse;

@FeignClient(name= "orderms" , fallback = OrderMSFallBack.class)
public interface OrderMS {
	
	@RequestMapping(value = "/order/submit", method = RequestMethod.POST)
	public String submitOrder(@RequestHeader("Authorization") String authorizationToken, @RequestBody List<CartEntity> cart);

}
