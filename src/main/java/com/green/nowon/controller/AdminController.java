package com.green.nowon.controller;

import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.GoodsInsertDTO;

import com.green.nowon.domain.dto.MemberListDTO;
import com.green.nowon.service.MemberService;

import com.green.nowon.domain.dto.GoodsListDTO;

import com.green.nowon.service.goodsservice.GoodsService;


@Controller
public class AdminController {
	
	@Autowired
	private GoodsService service;
	
	@Autowired
	private MemberService memberservice;
	
	@GetMapping("/admin")
	public String admin() {
		
		return "admin/admin";
	}
	
	@GetMapping("/admin/authority")
	public String authority(Model model) {
		memberservice.getList(model);
		return "admin/authority";
	}
	

	@GetMapping("/admin/delivery-status")
	public String deliveryStatus() {
		
		return "admin/delivery-status";
	}
	
	
	@GetMapping("/admin/goods")
	public String GoodsReg() {
		return "admin/goods/goods-reg";
	}
	

	@GetMapping("/admin/goods/list")
	public String goodsList(Model model) {
		service.list(model);
		return "/admin/goods/list";
	}
	
	@PostMapping("/admin/goods/reg")
	public String GoodsReg(GoodsInsertDTO dto) {
		service.save(dto);
		return "admin/goods/goods-reg";
	}
	


	
	@ResponseBody
	@PostMapping("/admin/temp-up")
	public Map<String, String> tempUp(MultipartFile gimg){
		return service.fileTempUp(gimg);
	}
	
	@GetMapping("/admin/common/goods/{no}")
	public String detail(@PathVariable long no,Model model) {
		service.detail(no, model);
		return "/admin/goods/detail";
	}
	
	@PatchMapping("/admin/update/{no}")
	public String update(@PathVariable long no,GoodsListDTO dto) {
	//	service.update(dto);
		System.out.println(dto);
		return "redirect:/admin/goods/list";	
	}
	
	@DeleteMapping("/admin/delete/{no}")
	public String delete(@PathVariable long no) {
		service.delete(no);
		return "redirect:/admin/goods/list";	
	}

}