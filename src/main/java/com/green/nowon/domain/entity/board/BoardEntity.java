package com.green.nowon.domain.entity.board;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.green.nowon.domain.dto.board.BoardUpdateDTO;
import com.green.nowon.domain.entity.BaseDateEntity;
import com.green.nowon.domain.entity.board.faq.Division;
import com.green.nowon.domain.entity.member.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_board")
@Entity
public class BoardEntity extends BaseDateEntity{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long bno;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String content;
	
	private int readCount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mno")
	private MemberEntity member;
	 
	//편의메서드
	public BoardEntity update(BoardUpdateDTO dto) {
		this.title=dto.getTitle();
		this.content=dto.getContent();
		return this;
	}

}
