package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.domain.entity.member.MemberEntityRepository;
import com.green.nowon.domain.entity.member.Role;
import com.green.nowon.service.LogService;

@Service
public class LogServiceProcess implements LogService {

	@Autowired
	private MemberEntityRepository repository;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Override
	public void save(MemberDTO dto) {
		repository.save(dto.toEntity(pe)
			.addRole(Role.USER));

	}

}
