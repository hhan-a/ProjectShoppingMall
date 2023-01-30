package com.green.nowon.domain.dto.order;

import com.green.nowon.domain.dto.GoodsListDTO;
import com.green.nowon.domain.entity.goods.GoodsEntity;

import lombok.Getter;

@Getter
public class OrderGoodsListDTO {
	private GoodsListDTO goods; //goods가격 불러오기
	
	private int quantity;
	
	private int totPrice;//수량에 따른 총 가격
	
	public OrderGoodsListDTO quantity(int quantity) {
		this.quantity=quantity;
		this.totPrice=quantity*(goods.getPrice()-goods.getSPrice());
		return this;
	}
	//주문금액
	public OrderGoodsListDTO (GoodsEntity e) {
		this.goods=new GoodsListDTO(e);
	}
}
