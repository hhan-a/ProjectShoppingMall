package com.green.nowon.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.nowon.service.BoardService;

@Controller
public class AdminOneController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/admin/one")
	public String BoardOneList(Model model) {
		boardService.getList(model);
		return "admin/board/one-list";
	}
	


}
