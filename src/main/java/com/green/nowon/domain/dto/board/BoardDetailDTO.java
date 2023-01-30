package com.green.nowon.domain.dto.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.green.nowon.domain.entity.board.BoardEntity;

import lombok.Getter;

@Getter
public class BoardDetailDTO {
	private long bno;
	private String title;
	private String content;
	private int readCount;
	private long writerMno;
	private String writerEmail;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	

	//entity-> dto  mapping하는 생성자
	public BoardDetailDTO(BoardEntity ent) {
		this.bno = ent.getBno();
		this.title = ent.getTitle();
		this.content = ent.getContent();
		this.readCount = ent.getReadCount();
		this.writerMno = ent.getMember().getMno();
		this.writerEmail = ent.getMember().getEmail(); //작성자는 이메일 정보로 대체
		this.createdDate = ent.getCreatedDate();
		this.updatedDate = ent.getUpdatedDate();
		
	}
	
	

	
	

}
