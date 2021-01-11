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
import org.springframework.web.bind.annotation.RequestParam;

import com.ms.bootcamp.dto.CartDTO;
import com.ms.bootcamp.dto.CartResponseDTO;

@FeignClient(name= "cartms" , fallback = CartMSFallBack.class)
public interface CartService {

	@PostMapping("/cart/add")
    public String addToCart(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId,@RequestParam Integer productId,@RequestParam Integer quantity) ;                                                                                                              

    @DeleteMapping("/cart/delete/item")
    public String deleteFromCart(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId,@RequestParam Integer productId);

    @PostMapping("/cart/update/item")
    public String updateQuantity(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId,@RequestParam Integer productId,@RequestParam Integer quantity);

    @GetMapping("/cart/checkout")
    public String checkout(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId);

    @GetMapping("/cart/details")
    public List<CartResponseDTO> getAllProducts(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId);
    
    @DeleteMapping("/cart/emptyCart")
    public String emptyCart(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId);
	
}
