package com.green.nowon.domain.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.domain.entity.member.MemberEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	
	private String email;
	private String pass;
	private String name;
	
	public MemberEntity toEntity(PasswordEncoder pe) {
		return MemberEntity.builder()
				.email(email)
				.pass(pe.encode(pass))
				.name(name)
				.build();
	}
	
}
