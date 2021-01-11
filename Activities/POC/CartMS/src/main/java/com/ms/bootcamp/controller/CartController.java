package com.ms.bootcamp.controller;

import com.ms.bootcamp.dto.CartDTO;
import com.ms.bootcamp.dto.ProductDTO;
import com.ms.bootcamp.entity.CartEntity;
import com.ms.bootcamp.entity.PrimaryKey;
import com.ms.bootcamp.service.CartService;
import com.ms.bootcamp.service.ProductMS;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class CartController {
	@Autowired
    private CartService cartService;
	
	@Autowired
	private ProductMS  productMS;
	
	//@Autowired
	//private CartDTO cartDTO;

    @PostMapping("/add/test")
    public String addToCartV1(@RequestBody CartDTO cartDTO){
        //Get userId of active user
        //CartDTO cartDTO=new CartDTO(productId,merchantId,quantity);
        return cartService.addToCart(cartDTO);
    }
    
    @PostMapping("/add")
    public String addToCart(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId,@RequestParam Integer productId,@RequestParam Integer quantity){
        //Get productId of active user
    	ProductDTO pDTO = productMS.getProductById(authorizationToken,productId);
    	 CartDTO cartDTO = new CartDTO();
    	BeanUtils.copyProperties(pDTO,cartDTO);
    	cartDTO.setUserId(userId);
    	cartDTO.setQuantity(quantity);
        return cartService.addToCart(cartDTO);
    }
    
    @DeleteMapping("/delete/test")
    public String deleteFromCartV1(@RequestBody CartDTO cartDTO){
        return cartService.deleteFromCart(cartDTO);
    }
    
    @DeleteMapping("/delete/item")
    public String deleteFromCart(@RequestParam Integer userId,@RequestParam Integer productId){
        return cartService.deleteFromCartV2(userId,productId);
    }

    @PostMapping("/update/test")
    public String updateQuantityV1(@RequestBody CartDTO cartDTO){
        return cartService.updateInCart(cartDTO);
    }
    
    @PostMapping("/update/item")
    public String updateQuantity(@RequestParam Integer userId,@RequestParam Integer productId,@RequestParam Integer quantity){
        return cartService.updateInCartV2(userId,productId,quantity);
    }

    @GetMapping("/checkout")
    public String checkout(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId){
        return cartService.checkout(authorizationToken,userId);
    }

    @GetMapping("/details")
    public List<CartEntity> getAllProducts(@RequestParam Integer userId){
        return cartService.getAllProducts(userId);
    }
    
    @DeleteMapping("/emptyCart")
    public String emptyCart(@RequestParam Integer userId){
        return cartService.deleteFromCartByID(userId);
    }



}

