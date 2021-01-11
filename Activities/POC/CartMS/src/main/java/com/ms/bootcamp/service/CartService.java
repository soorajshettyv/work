package com.ms.bootcamp.service;


import com.ms.bootcamp.dto.CartDTO;
import com.ms.bootcamp.dto.ProductDTO;
import com.ms.bootcamp.entity.CartEntity;
import com.ms.bootcamp.entity.PrimaryKey;
import com.ms.bootcamp.repository.CartRepository;
//import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;




@Service
@Component
@Transactional
public class CartService {
	
	@Autowired
    CartRepository cartRepository;
	
	@Autowired
	OrderMS orderMS;
	


    public String addToCart(CartDTO cartDTO) {
    	if (!idExist(cartDTO)) {
        CartEntity cartEntity=new CartEntity();

        BeanUtils.copyProperties(cartDTO,cartEntity);
        //cartEntity.setQuantity(cartDTO.getQuantity());
        //cartEntity.setId(primaryKey);
         double total_price = cartDTO.getQuantity()*cartDTO.getPrice_per_unit();
           cartEntity.setPrice(total_price);
          
        
       
        CartEntity result=cartRepository.save(cartEntity);
        if(result!=null)
            return "Successfully Added.";
        else
            return "Product not added in the cart.";
    }
    return "Product Id already exist for user ,call cart update instead";	
    }

    public String deleteFromCart(CartDTO cartDTO) {
    	if (idExist(cartDTO)) {
        CartEntity cartEntity=new CartEntity();
        BeanUtils.copyProperties(cartDTO,cartEntity);
        double total_price = cartDTO.getQuantity()*cartDTO.getPrice_per_unit();
        cartEntity.setPrice(total_price);
        cartRepository.delete(cartEntity);
        return "success";
    	}
    	return "user cart is empty";

    }
    
    public String deleteFromCartV2(int userId, int productId) {
    	PrimaryKey pk = new PrimaryKey(userId,productId);
    	Optional<CartEntity> cartOpt =	cartRepository.findById(pk);
       	if(cartOpt.isPresent()) {
       		cartRepository.deleteById(pk);
       		return "ProductId:" +productId +" deleted for userId:"+userId; 
    	}
    	return "ProductId:" +productId +" not found in cart for userId:"+userId;
    }

//    public List<CartEntity> checkout(Integer userId) {
//        CartEntity result=null;
//        List<CartEntity> finalresult=null;
//      //  for(result : cartRepository.findByUserId(userId.toString())){
//        //    finalresult.add(result);
//
//       // }
//         List<CartEntity> a= (List<CartEntity>) cartRepository.findByUserId(userId.toString());
//        return a;
//    }
/**/
public String deleteFromCartByID(Integer userId) {
  cartRepository.deleteByUserId(userId);
  return " , Cart is now empty";
  
  }

    public String checkout(String authorizationToken, Integer userId){
    	List<CartEntity> cart=cartRepository.findByuserId(userId);
        String result=orderMS.submitOrder(authorizationToken,cart);
    	//auditService.pubAuditEvent(cart);
        if(result!=null & result!= "" & result != "OrderMS not available, please try later")
        result= result +deleteFromCartByID(userId);
        return result;
    }
    
    

    public List<CartEntity> getAllProducts(Integer userId){
        List<CartEntity> result=cartRepository.findByuserId(userId);
        return result;
    }



    public String updateInCart(CartDTO cartDTO) {
        //cartDTO.setQuantity((cartDTO.getQuantity()-1));
    	if (idExist(cartDTO)) {
        CartEntity cartEntity=new CartEntity();
        BeanUtils.copyProperties(cartDTO,cartEntity);
        double total_price = cartDTO.getQuantity()*cartDTO.getPrice_per_unit();
        cartEntity.setPrice(total_price);
        CartEntity result;
        result=cartRepository.save(cartEntity);
        if(result.getQuantity()>1){
            return "Cart updated";
        }
        else{
            deleteFromCart(cartDTO);
            return "Product Removed";
        }
        
    	}
    	return "Product doenst not exist for user";
    	
    }
    
    public String updateInCartV2(int userId, int productId,int quantity) {
        PrimaryKey pk = new PrimaryKey(userId,productId);
        Optional<CartEntity> cartOpt =	cartRepository.findById(pk);
    	if (cartOpt.isPresent()) {
        CartEntity cartEntity=cartOpt.get();
        double total_price = quantity*cartEntity.getPrice_per_unit();
        cartEntity.setPrice(total_price);
        cartEntity.setQuantity(quantity);
        CartEntity result;
        result=cartRepository.save(cartEntity);
        if(result.getQuantity()>1){
            return "Cart updated";
        }
        else{
        	deleteFromCartV2(userId, productId);
            return "Product Removed";
        }
        
    	}
    	return "Product doenst not exist for user";
    	
    }
    
public boolean idExistV2(int userId, int productId) {
    	
    	PrimaryKey pk = new PrimaryKey(userId,productId);
       	//pk.setProductId(cartDTO.getProductId());
       	//pk.setUserId(cartDTO.getUserId());
       	Optional<CartEntity> cartOpt =	cartRepository.findById(pk);
       	if(cartOpt.isPresent()) {
    	return true;
    	}
       	return false;
    }
    
    
    public boolean idExist(CartDTO cartDTO) {
    	
    	PrimaryKey pk = new PrimaryKey(cartDTO.getUserId(),cartDTO.getProductId());
       	//pk.setProductId(cartDTO.getProductId());
       	//pk.setUserId(cartDTO.getUserId());
       	Optional<CartEntity> cartOpt =	cartRepository.findById(pk);
       	if(cartOpt.isPresent()) {
    	return true;
    	}
       	return false;
    }
}


