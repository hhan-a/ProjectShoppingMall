package com.green.nowon.domain.dto.board;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.green.nowon.domain.entity.board.BoardEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardListDTO {
	
	private long mno;
	private String title;
	private String content;
	private LocalDateTime createdDate;
	
	//Entity를 BoardListDTO(BoardEntity ent)에 매핑하여 가져갈거야
	public BoardListDTO(BoardEntity ent) {
		this.mno = ent.getMember().getMno();
		this.title = ent.getTitle();
		this.content = ent.getContent();
		this.createdDate=ent.getCreatedDate();
	}

	
	

}
