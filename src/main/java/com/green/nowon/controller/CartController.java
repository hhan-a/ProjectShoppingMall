package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.CartItemSaveDTO;
import com.green.nowon.security.MyUserDetails;
import com.green.nowon.service.CartService;
import com.green.nowon.service.impl.CartServiceProcess;


@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	
	@ResponseBody
	@PostMapping("/cart")
	public void cartItem(CartItemSaveDTO dto, @AuthenticationPrincipal MyUserDetails myUserDetails) {
		service.save(dto, myUserDetails.getEmail());
	}
	
	@GetMapping("/carts")
	public String cart(Model model, @AuthenticationPrincipal MyUserDetails myUserDetails) {
		service.cartItems(model, myUserDetails.getEmail());
		return "member/cart";
	}
}
