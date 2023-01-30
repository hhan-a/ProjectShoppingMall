package com.green.nowon.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.entity.member.MemberEntityRepository;
import com.green.nowon.service.MemberService;

@Service
public class MemberServiceProcess implements MemberService {

	@Autowired
	private MemberEntityRepository memRepo;
	
	@Override
	public void getList(Model model) {
		model.addAttribute("list", memRepo.findAll());
	}
	
	@Transactional
	@Override
	public void deleteMno(long mno) {
		memRepo.deleteByMno(mno);
		
	}

}
