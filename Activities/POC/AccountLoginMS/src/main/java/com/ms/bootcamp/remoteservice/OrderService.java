package com.ms.bootcamp.remoteservice;

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

@FeignClient(name= "orderms" , fallback = OrderMSFallBack.class)
public interface OrderService {

	@PostMapping("/order/view")
    public String viewOrder(@RequestHeader("Authorization") String authorizationToken,@RequestParam Long orderId);
 	
	@PostMapping("/order/view/user/orderlist")
    public String viewUserOrders(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId);
}
