package com.green.nowon.domain.entity.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.green.nowon.domain.entity.goods.GoodsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_order_goods")
@Entity
public class OrderGoodsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;

	private int orderPrice;//주문금액
	private int orderQuantity;//주문수량
	
	@JoinColumn//order_no
	@ManyToOne
	private OrderEntity order;
	
	@JoinColumn//goods_no
	@ManyToOne
	private GoodsEntity goods;
}
