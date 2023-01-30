package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.service.FaqService;
import com.green.nowon.service.impl.FaqServiceProcess;

@Controller
public class FaqController {
	
	@Autowired
	private FaqService service;
	
	@GetMapping("/board")
	public String boardlist() {
		return "board/page/faq";
	}
	
	//division, page
	//HTML응답을 하기 위해 ModelAndView 이용
	//ajax요청시 실행되는 GetMapping 메서드
	@ResponseBody //ModelAndView의 ViewName에 설정된 HTML 응답객체로 사용
	@GetMapping("/board/{division}/{page}")
	public ModelAndView customers(@PathVariable String division, @PathVariable int page, ModelAndView mv) {
		
		service.listForAjax(mv, division, page);
		
		mv.setViewName("board/page/list");
		//@ResponseBody 없을때 리턴형이 String이면 ViewResolver 처리대상인 templates
		
		return mv;
	}
	
	
}
