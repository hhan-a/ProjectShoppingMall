package com.green.nowon.domain.entity.board.faq;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.green.nowon.domain.dto.board.faq.FaqDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_faq")
@Entity
public class FaqEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long fno;
	private String division;
	private String question;
	private String answer;
	
	
}
