package com.green.nowon.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.nowon.service.FaqService;

@Controller
public class AdminFaqController {
	
	@Autowired
	private FaqService faqService;

	@GetMapping("/admin/faq")
	public String BoardFaqList(Model model) {
		faqService.getList(model);
		return "admin/board/faq-list";
	}
	
}
