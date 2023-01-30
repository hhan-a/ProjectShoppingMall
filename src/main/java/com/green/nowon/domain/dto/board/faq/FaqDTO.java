package com.green.nowon.domain.dto.board.faq;

import com.green.nowon.domain.entity.board.faq.FaqEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter //getter가 있어야 가져오지
public class FaqDTO {
	private String division;
	private String question;
	private String answer;
	
	public FaqDTO(String division, String question, String answer) {
		this.division = division;
		this.question = question;
		this.answer = answer;
	}
	
	public FaqEntity toEntity() {
		return FaqEntity.builder()
				.division(division)
				.question(question)
				.answer(answer)
				.build();
	}

	public FaqDTO(FaqEntity e) {
		this.division = e.getDivision();
		this.question = e.getQuestion();
		this.answer = e.getAnswer();
	}
	
	

}
