package com.green.nowon.domain.entity.order;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.green.nowon.domain.entity.BaseDateEntity;
import com.green.nowon.domain.entity.delivery.DeliveryEntity;
import com.green.nowon.domain.entity.member.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_order")
@Entity
public class OrderEntity extends BaseDateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ono;//주문번호
	
	@CreationTimestamp
	private LocalDateTime orderDate; //주문한 날짜
	
	@Enumerated(EnumType.STRING)
	private OrderStaus status;//주문상태
	
	private String paymentNo;//merchant_uid
	
	
	@JoinColumn//member_mno
	@ManyToOne
	private MemberEntity member;//주문자 정보
	
	@JoinColumn
	@OneToOne
	private DeliveryEntity delivery;
}