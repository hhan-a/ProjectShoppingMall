package com.green.nowon.domain.entity.board;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.green.nowon.domain.entity.BaseDateEntity;
import com.green.nowon.domain.entity.goods.GoodsEntity;
import com.green.nowon.domain.entity.member.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_review")
@Entity
public class ReviewEntity extends BaseDateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rno;
	@Column(nullable = false)
	private int rating;
	@Column(nullable = false)
	private String content;
	
	 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mno")
	private MemberEntity member;

	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name="gno")
	private GoodsEntity goods;
	
}
