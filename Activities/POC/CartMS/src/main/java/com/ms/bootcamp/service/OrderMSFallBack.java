package com.ms.bootcamp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ms.bootcamp.entity.CartEntity;

@Component
public class OrderMSFallBack implements OrderMS{

	@Override
	public String submitOrder(String authorizationToken,List<CartEntity> cart) {
		// TODO Auto-generated method stub
		return "OrderMS not available, please try later";
	}

}
