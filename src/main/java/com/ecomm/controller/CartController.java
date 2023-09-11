package com.ecomm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecomm.exception.ProductException;
import com.ecomm.exception.UserException;
import com.ecomm.modal.Cart;
import com.ecomm.modal.User;
import com.ecomm.request.AddItemRequest;
import com.ecomm.response.ApiResponse;
import com.ecomm.service.CartService;
import com.ecomm.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	private CartService cartService;
	private UserService userService;
	
	public CartController(CartService cartService,UserService userService) {
		this.cartService=cartService;
		this.userService=userService;
	}
	
	@GetMapping("/")
	public ResponseEntity<Cart> findUserCartHandler(@PathVariable) throws UserException{

		User user=userService.findUserProfileByJwt(jwt);

		Cart cart=cartService.findUserCart(user.getId());

		System.out.println("cart - "+cart.getUser().getEmail());

		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}

	@PutMapping("/add")
	public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
		
		User user=userService.findUserProfileByJwt(jwt);
		
		cartService.addCartItem(user.getId(), req);
		
		ApiResponse res= new ApiResponse("Item Added To Cart Successfully",true);
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
		
	}
	

}