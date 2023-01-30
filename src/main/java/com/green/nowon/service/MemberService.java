package com.green.nowon.service;

import org.springframework.ui.Model;

public interface MemberService {

	void getList(Model model);
	
	void deleteMno(long mno);

}
