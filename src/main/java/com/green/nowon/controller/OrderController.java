package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.order.DeliveryInfoDTO;
import com.green.nowon.domain.dto.order.OrderGoodsDTO;
import com.green.nowon.security.MyUserDetails;
import com.green.nowon.service.order.OrderService;

@Controller
public class OrderController {
	
	@GetMapping("/order/list")
	public String orderList() {
		return "order/order-list";
	}
	
	
	
	@Autowired
	private OrderService service;
	
	@ResponseBody
	@PostMapping("/order/deliveryInfo")
	public void deliveryInfo(DeliveryInfoDTO dto, @AuthenticationPrincipal MyUserDetails uDetail) {
		service.deliveryInfoSave(dto, uDetail.getEmail());
	}
	
	@GetMapping("/order/order")
	public String orderPayment(OrderGoodsDTO dto,Model model) {
		service.orderGoods(dto, model);
		return "order/order";
	}
	

	
	 @GetMapping("/order/address/base")
	 public String baseAddrs(@AuthenticationPrincipal MyUserDetails userDetails,Model model) {
		 service.baseAddress(userDetails.getEmail(),model);
		 return "order/address-base";
	 }
	 
	@GetMapping("/order/addres-list")
	public String addresList(@AuthenticationPrincipal MyUserDetails userDetails,Model model) {
		service.addresList(userDetails.getEmail(), model);
		return "order/addres-list";
	}
	
}
