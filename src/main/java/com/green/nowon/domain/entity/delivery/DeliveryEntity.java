package com.green.nowon.domain.entity.delivery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.green.nowon.domain.entity.member.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_delivery")
@Entity
public class DeliveryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private boolean base;//기존주소
	
	@Column(nullable = false)
	private String receivName;//수령자 이름
	@Column(nullable = false)
	private String phone;//연락처
	@Column(nullable = false)
	private String postcode;//우편번호
	@Column(nullable = false)
	private String roadAddr;//도로명주소
	@Column(nullable = false)
	private String jibunAddr;//지번
	@Column(nullable = false)
	private String detailAddr;//상세주소 ex)XxX동XxX호
	@Column(nullable = false)
	private String extraAddr;//요청사항
	

	@JoinColumn(name = "mno")//member_mno
	@ManyToOne
	private MemberEntity member;
	
	public DeliveryEntity member(MemberEntity member) {
		this.member=member;
		return this;
	}
	
	public DeliveryEntity base(boolean base) {
		this.base=base;
		return this;
	}

}