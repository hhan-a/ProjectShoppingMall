package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.cart.CartItemEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemListDTO {
	
	private long no;//cartItem번호
	private int quantity;//구매수량
	
	//배송비
	private int dPrice;
	
	//할인정보
	private int sPrice;
	
	//item 정보 기존 item dto활용
	private GoodsListDTO goods;

	public CartItemListDTO(CartItemEntity e) {
		this.no = e.getCino();
		this.quantity = e.getCount();
		this.goods = new GoodsListDTO(e.getGno());
		
	}
	
}
