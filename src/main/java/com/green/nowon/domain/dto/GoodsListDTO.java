package com.green.nowon.domain.dto;

import java.util.List;

import com.green.nowon.domain.entity.category.CategoryItemEntity;
import com.green.nowon.domain.entity.goods.GoodsEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GoodsListDTO {
	
	private long no;
	private String title;
	private int price;

	private String content;
	//이미지테이블에 저장되어있음
	private String imgUrl;

	private int stock;
	
	private int sPrice;//세일
	private int dPrice;//배송비
	private String defImgUrl;

	private List<GoodsListImgDTO> img;

	public GoodsListDTO(GoodsEntity e) {
		this.no = e.getGoodsNo();
		this.title = e.getTitle();
		this.price = e.getPrice();
		this.stock = e.getStock();
		this.defImgUrl = e.defImg().getUrl()+e.defImg().getNewName();
		sPrice=0;
		dPrice=2500;
	}
	public GoodsListDTO(CategoryItemEntity cie) {
		this(cie.getItem());
	}
	
		

}