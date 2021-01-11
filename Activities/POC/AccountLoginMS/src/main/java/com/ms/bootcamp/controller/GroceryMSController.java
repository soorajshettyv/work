package com.ms.bootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.bootcamp.dto.CartResponseDTO;
import com.ms.bootcamp.dto.ProductDTO;
import com.ms.bootcamp.remoteservice.CartService;
import com.ms.bootcamp.remoteservice.NODataFoundException;
import com.ms.bootcamp.remoteservice.OrderService;
import com.ms.bootcamp.remoteservice.ProductService;
import com.ms.bootcamp.model.ProductMessageRepsonse;
import com.ms.bootcamp.repository.RoleRepository;
import com.ms.bootcamp.repository.UserRepository;
import com.ms.bootcamp.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/grocery")
@PreAuthorize("hasRole('ADMIN')")
public class GroceryMSController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/product/add") //create new Product
	public ProductMessageRepsonse addProduct(@RequestHeader("Authorization") String authorizationToken,@RequestBody ProductDTO product) {
		ProductMessageRepsonse response =  productService.addProduct(authorizationToken,product);
		return response;
		
	}

        @PutMapping("/product/update") //update existing product
	public ProductDTO updateProduct(@RequestHeader("Authorization") String authorizationToken,@RequestBody ProductDTO product) throws NODataFoundException{
		
        	ProductDTO pDTO = productService.updateProduct(authorizationToken,product);
        	return pDTO;
		
	}

        @GetMapping("/product/all") //List all products
	public List<ProductDTO> getProduct(@RequestHeader("Authorization") String authorizationToken){
        	List<ProductDTO> productList=	productService.getProduct(authorizationToken);
		return productList;
		
	}

        @GetMapping("/product/{productId}") //List given product
	public  ProductDTO  getProductById(@RequestHeader("Authorization") String authorizationToken,@PathVariable int productId) throws NODataFoundException{
        	ProductDTO pDTO = productService.getProductById(authorizationToken,productId);
		 return pDTO;
        }

        
        @DeleteMapping("/product/delete/{productname}")
	public String deleteProduct(@RequestHeader("Authorization") String authorizationToken,@PathVariable String productname) throws NODataFoundException {
        	try {
        	productService.deleteProduct(authorizationToken,productname);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	return "product deleted"+ productname;
        }
	
        @PostMapping("/cart/add")
        public String addToCart(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId,@RequestParam Integer productId,@RequestParam Integer quantity)   {
        	
        	String msg =cartService.addToCart(authorizationToken, userId, productId, quantity);
			return msg;
        	
        }

        @DeleteMapping("/cart/delete")
        public String deleteFromCart(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId,@RequestParam Integer productId) {
        	String msg =cartService.deleteFromCart(authorizationToken, userId, productId);
			return msg;
        	
        }

        @PostMapping("/cart/update")
        public String updateQuantity(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId,@RequestParam Integer productId,@RequestParam Integer quantity) {
        	String msg =cartService.updateQuantity(authorizationToken, userId, productId, quantity);
        	return msg;
        	
        }

        @GetMapping("/checkout/{userId}")
        public String checkout(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId) {
        	String msg =cartService.checkout(authorizationToken,userId);
			return msg;
        	
        }

        @GetMapping("/cart/list/{userId}")
        public List<CartResponseDTO> getAllProducts(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId){
        	List<CartResponseDTO> productList = cartService.getAllProducts(authorizationToken,userId);
			return productList;
        	
        }
        
        @DeleteMapping("/cart/remove/{userId}")
        public String emptyCart(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId) {
        	String msg =cartService.emptyCart(authorizationToken,userId);
        	return msg;
        	
        }
        
        @PostMapping("/order/view/")
        public String viewOrder(@RequestHeader("Authorization") String authorizationToken,@RequestParam Long orderId) {
        	String msg = orderService.viewOrder(authorizationToken,orderId);
        	return msg;
        	
        }
        
        @PostMapping("/order/view/user")
        public String viewOrderList(@RequestHeader("Authorization") String authorizationToken,@RequestParam Integer userId) {
        	String msg = orderService.viewUserOrders(authorizationToken, userId);
        
        	return msg;
        }
        
        
}
