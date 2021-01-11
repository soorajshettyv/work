package com.ms.bootcamp.service;

import com.ms.bootcamp.dto.OrderRequestDTO;
import com.ms.bootcamp.dto.OrderResponseDTO;
import com.ms.bootcamp.entity.OrderEntity;
import com.ms.bootcamp.entity.OrderID;
import com.ms.bootcamp.entity.PrimaryKey;
import com.ms.bootcamp.repository.OrderRepository;
import com.ms.bootcamp.repository.OrderIDRepository;
//import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
//import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderIDRepository orderIDRepository;
	
	
	

   public long createOrder(List<OrderRequestDTO> orderRequestDTOList) {
	   long orderId = 0L;
	   double orderCost = 0.0;
   try{
	  // System.out.println("Inside createOrder Try ");
	   orderId= generateOrderId();
	   
   LocalDate date = LocalDate.now(); 
   LocalDateTime timeStamp= LocalDateTime.now();
   List<OrderEntity> orderEntityList = new ArrayList<>();
   int userId= orderRequestDTOList.get(0).getUserId();
   for(OrderRequestDTO orderRequestDTO: orderRequestDTOList) {
	   //System.out.println("Inside createOrder for loop ");
	   OrderEntity orderEntity=new OrderEntity();
       BeanUtils.copyProperties(orderRequestDTO,orderEntity);
       orderEntity.setOrderId(orderId);
       orderEntity.setOrderDate(date);
       orderEntity.setTimeStamp(timeStamp);
       orderCost = orderCost + orderRequestDTO.getPrice();
       
       orderEntityList.add(orderEntity);
  
   }
   
   System.out.println("Outside createOrder for loop ");
   OrderID oid = new OrderID();
   oid.setOrderId(orderId);
   oid.setUserId(userId);
   oid.setOrderCost(orderCost);
   orderRepository.saveAll(orderEntityList);
   orderIDRepository.save(oid);
   //System.out.println(" createOrder end ");
   //return orderId;
   }catch(Exception e) {
	   
	   e.printStackTrace();
   }
   System.out.println("OrderID:" +orderId);
   return orderId;
   }
   
   
/*     This method generates a semi-unique ID by 
	 * packing a millisecond timestamp-component together with a counter-component. 
	 * The algorithm allows for roughly a million (or 1048575 to be exact) unique IDs 
	 * to be generated in the same millisecond before collisions start to occur. 
	 * Unique IDs are generated until the year 2248 at which point 
	 * it will wrap around and start at 0 again. */
private long generateOrderId() {
	
	long previousTimeMillis = System.currentTimeMillis();
    long counter = 0L;
long currentTimeMillis = System.currentTimeMillis();
counter = (currentTimeMillis == previousTimeMillis) ? (counter + 1L) & 1048575L : 0L;
previousTimeMillis = currentTimeMillis;
long timeComponent = (currentTimeMillis & 8796093022207L) << 20;
return timeComponent | counter;
}


public List<OrderEntity> getOrderItemsHistoryForUserId(Integer userId){
    List<OrderEntity> result=orderRepository.findByuserId(userId);
    return result;
}

public OrderResponseDTO getOrderByOrderId(Long oid){
    List<OrderEntity> result=orderRepository.findByOrderId(oid);
    OrderID orderID = orderIDRepository.findByOrderId(oid);
    
    double cost= orderID.getOrderCost();
    OrderResponseDTO dto = new OrderResponseDTO(result,cost);
    
    return dto;
}

public OrderID getOrderId(long oid){ 
	 OrderID orderID = orderIDRepository.findByOrderId(oid);
	   return orderID;
	   }


public List<OrderID> getOrderbyuserId(Integer uid){ 
	 List<OrderID> orderID = orderIDRepository.findByUserId(uid);
	   return orderID;
	   }

/*
 * 
public OrderID getOrderId(Long oid){ 
 OrderID orderID = orderIDRepository.findByOrderID(oid);
   return orderID;
   }
   public OrderResponseDTO getOrderByOrderId(Long oid){
    List<OrderEntity> result=orderRepository.findByIdOrderID(oid);
    Optional<OrderID> orderID = orderIDRepository.findByOrderID(oid);
    
    long cost= orderID.getOrderCost();
    OrderResponseDTO dto = new OrderResponseDTO(result,cost);
    
    return dto;
}
    public String addToCart(CartDTO cartDTO) {
    	if (!idExist(cartDTO)) {
        CartEntity cartEntity=new CartEntity();

        BeanUtils.copyProperties(cartDTO,cartEntity);
        //cartEntity.setQuantity(cartDTO.getQuantity());
        //cartEntity.setId(primaryKey);
         double total_price = cartDTO.getQuantity()*cartDTO.getPrice_per_unit();
           cartEntity.setPrice(total_price);
          
        OrderResponseDTO orsdto = new OrderResponseDTO();
       
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

    public List<CartEntity> checkout(Integer userId){
        List<CartEntity> result=cartRepository.findByuserId(userId);
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
    
    */
    
    
    
    public boolean idExist(OrderRequestDTO orderRequestDTO,OrderEntity orderEntity) {
    	
    	PrimaryKey pk = new PrimaryKey(orderEntity.getOrderId(),orderRequestDTO.getUserId(),orderRequestDTO.getProductId());
       	//pk.setProductId(cartDTO.getProductId());
       	//pk.setUserId(cartDTO.getUserId());
       	Optional<OrderEntity> orderOpt =	orderRepository.findById(pk);
       	if(orderOpt.isPresent()) {
    	return true;
    	}
       	return false;
    }
}


