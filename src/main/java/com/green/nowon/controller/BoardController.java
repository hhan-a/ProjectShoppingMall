package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.board.BoardSaveDTO;
import com.green.nowon.security.MyUserDetails;
import com.green.nowon.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/board/oneonone")
	public String boardlist(Model model,  @AuthenticationPrincipal MyUserDetails myUserDetails) {
		service.boardlist(model, myUserDetails.getMno());
		//System.out.println(">>>>> mno : "+mno);
		return "board/page/one";
	}
	
	@PostMapping("/board/oneonone")
	public String boardSave(BoardSaveDTO dto, @AuthenticationPrincipal MyUserDetails myUserDetails) {
		service.save(dto, myUserDetails.getName());
		return "redirect:/board/oneonone";
	}
	

	
}
