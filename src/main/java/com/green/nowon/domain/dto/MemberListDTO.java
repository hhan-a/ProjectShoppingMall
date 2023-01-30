package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import com.green.nowon.domain.entity.member.MemberEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberListDTO {
	
	private long mno;
	private String email;
	private String name;
	private LocalDateTime createdDate;
	
	
	public MemberListDTO(MemberEntity e) {
		this.mno = e.getMno();
		this.email = e.getEmail();
		this.name = e.getName();
		this.createdDate = e.getCreatedDate();
	}
	
	
}
