package com.ms.bootcamp.controller;

import com.ms.bootcamp.audit.AuditService;
import com.ms.bootcamp.dto.OrderRequestDTO;
import com.ms.bootcamp.dto.OrderResponseDTO;
import com.ms.bootcamp.entity.OrderEntity;
import com.ms.bootcamp.entity.OrderID;
import com.ms.bootcamp.entity.PrimaryKey;
import com.ms.bootcamp.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class OrderController {
	@Autowired
    private OrderService orderService;
	
	@Autowired
	private AuditService auditService;
	
	@PostMapping("/submit")
    public String submitOrder(@RequestBody List<OrderRequestDTO> orderRequest){
        
        long id=orderService.createOrder(orderRequest);
        OrderID orderIdobj = orderService.getOrderId(id);
        double cost= orderIdobj.getOrderCost();
        String msg= "Order Id:"+id+" , Total Cost:"+cost+" Rs";
        auditService.pubAuditEvent(msg);
        return msg; 
    }
	
public String submitOrderV2(List<OrderRequestDTO> orderRequest){
	    long id=0L;
	    double cost=0.0;
	    System.out.println("orderRequest: "+orderRequest);
         id=orderService.createOrder(orderRequest);
        OrderID orderIdobj = orderService.getOrderId(id);
         cost= orderIdobj.getOrderCost();
        String msg= "Order Id:"+id+" , Total Cost:"+cost+" Rs";
        auditService.pubAuditEvent(msg);
        return msg; 
    }
	
	@PostMapping("/view")
    public String viewOrder(@RequestParam Long orderId){
        OrderResponseDTO orderDTO = orderService.getOrderByOrderId(orderId);
        
        
        String msg= "Order details:"+orderDTO+" " ;
        return msg; 
    }

	@PostMapping("/view/user/orderlist")
    public String viewUserOrders(@RequestParam Integer userId){
        List<OrderID> orderDTO = orderService.getOrderbyuserId(userId);
        
        String msg= "Order details:"+orderDTO+" " ;
        return msg; 
    }
	/*
	 * 
	
    @PostMapping("/view")
    public String viewOrder(@RequestParam Long orderId){
        OrderResponseDTO orderDTO = getOrderByOrderId(orderId)
        
        
        String msg= "Order details:"+orderDTO+" ;
        return msg; 
    }
    
    @PostMapping("/add")
    public String addToCart(@RequestBody CartDTO cartDTO){
        //Get userId of active user
        //CartDTO cartDTO=new CartDTO(productId,merchantId,quantity);
        return cartService.addToCart(cartDTO);
    }

    @DeleteMapping("/delete")
    public String deleteFromCart(@RequestBody CartDTO cartDTO){
        return cartService.deleteFromCart(cartDTO);
    }

    @PostMapping("/update")
    public String updateQuantity(@RequestBody CartDTO cartDTO){
        return cartService.updateInCart(cartDTO);
    }

    @GetMapping("/checkout")
    public List<CartEntity> checkout(@RequestParam Integer userId){
        return cartService.checkout(userId);
    }

    @GetMapping("/details")
    public List<CartEntity> getAllProducts(@RequestParam Integer userId){
        return cartService.getAllProducts(userId);
    }
*/


}

