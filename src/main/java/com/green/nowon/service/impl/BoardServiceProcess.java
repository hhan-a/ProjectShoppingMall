package com.green.nowon.service.impl;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.board.BoardListDTO;
import com.green.nowon.domain.dto.board.BoardSaveDTO;
import com.green.nowon.domain.entity.board.BoardEntity;
import com.green.nowon.domain.entity.board.BoardEntityRepository;
import com.green.nowon.domain.entity.member.MemberEntityRepository;
import com.green.nowon.service.BoardService;

@Service
public class BoardServiceProcess implements BoardService {

	@Autowired
	BoardEntityRepository boardRepo;
	
	@Autowired
	MemberEntityRepository memberRepo;
	
	
	@Transactional
	@Override
	public void save(BoardSaveDTO dto, String name) {
		BoardEntity board = boardRepo.save(BoardEntity.builder()
						.member(memberRepo.findByName(name).orElseThrow())
						.title(dto.getTitle())
						.content(dto.getContent())
						.build());
	}

	@Override
	public void boardlist(Model model, Long mno) {
		model.addAttribute("list", boardRepo.findAllByMemberMno(mno)
				.stream()
				.map(BoardListDTO :: new)
				.collect(Collectors.toList()));
		
		
	}

	@Override
	public void getList(Model model) {
		model.addAttribute("list", boardRepo.findAll());
		
	}


}
