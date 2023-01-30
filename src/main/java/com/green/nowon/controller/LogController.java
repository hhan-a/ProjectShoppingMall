package com.green.nowon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.service.LogService;
import com.green.nowon.service.MemberService;

@Controller
public class LogController {
	
	@Autowired
	private LogService service;
	
	@Autowired
	private MemberService memservice;
	
	/*
	@GetMapping("/login")
	public String login() {
		return "log/login";
	}
	*/
	@GetMapping("/signup")
	public String signup() {
		return "log/signup";
	}
	
	@PostMapping("/signup")
	public String signup(MemberDTO dto) {
		service.save(dto);
		return "redirect:/login";
	}

	@DeleteMapping("/delete/{mno}")
	public String delete(@PathVariable long mno) {
		memservice.deleteMno(mno);
		return "redirect:/admin/authority";

	}	

	@ResponseBody
	@GetMapping("/member/login-check")
	public boolean loginCheck(Authentication auth) {
		System.out.println(auth);
		//로그인했을때는 인증정보확인가능
		//비로그인시는 null
		System.out.println("인증 : "+auth);
		return auth==null? false:true;

	}
	
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		//로그인페이지로 이동하기 전 페이지 정보
		String prevPageUrl = request.getHeader("Referer");
		System.out.println("prevPage : "+prevPageUrl);
		
		//로그인페이지에서 다시 로그인요청된 경우는 제외
		if(prevPageUrl!=null && !prevPageUrl.contains("/login")) { 
			request.getSession().setAttribute("prevPage", prevPageUrl);
		}
		return "log/login";
	}

}
