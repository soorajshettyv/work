package com.ms.bootcamp.remoteservice;

import org.springframework.stereotype.Component;

@Component
public class OrderMSFallBack implements OrderService {

	@Override
	public String viewOrder(String token,Long orderId) {
		// TODO Auto-generated method stub
		return "OrderService unavailable for Order view";
	}

	@Override
	public String viewUserOrders(String authorizationToken, Integer userId) {
		// TODO Auto-generated method stub
		return "OrderService unavailable for order list view";
	}

}
