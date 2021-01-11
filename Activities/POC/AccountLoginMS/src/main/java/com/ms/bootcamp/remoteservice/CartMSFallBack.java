package com.ms.bootcamp.remoteservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ms.bootcamp.dto.CartDTO;
import com.ms.bootcamp.dto.CartResponseDTO;

@Component
public class CartMSFallBack implements CartService {


	@Override
	public String checkout(String token,Integer userId) {
		// TODO Auto-generated method stub
		return "cartms or orderms  service unavailable for checkout";
	}

	@Override
	public List<CartResponseDTO> getAllProducts(String token,Integer userId) {
		// TODO Auto-generated method stub
		CartResponseDTO cartDTO= new CartResponseDTO(0, 0, 0, "n/a", 0.0,
				"n/a", "NA", 0.0);
		
		List<CartResponseDTO> cartList = new ArrayList<CartResponseDTO>();
		cartList.add(cartDTO);
		return cartList;
	}

	@Override
	public String emptyCart(String token,Integer userId) {
		// TODO Auto-generated method stub
		return "Cart Service unavailable for emptyCart method";
	}

	@Override
	public String addToCart(String authorizationToken, Integer userId, Integer productId, Integer quantity) {
		// TODO Auto-generated method stub
		return "cartms unavailable for addToCart";
	}

	@Override
	public String deleteFromCart(String authorizationToken, Integer userId, Integer productId) {
		// TODO Auto-generated method stub
		return "cartms unavailable for delete";
	}

	@Override
	public String updateQuantity(String authorizationToken, Integer userId, Integer productId, Integer quantity) {
		// TODO Auto-generated method stub
		return "cartms unavailable for update";
	}

	
}
