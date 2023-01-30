package com.green.nowon.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.green.nowon.domain.entity.category.CategoryItemEntity;
import com.green.nowon.domain.entity.goods.GoodsEntity;

import lombok.Data;

@Data
public class GoodsDetailDTO {
	private long no;
	private String title;
	private String content;
	private int price;
	private int stock;
	
	//이미지 대표이미지
	private String defImgUrl;
	
	private List<GoodsListImgDTO> imgs;

	public GoodsDetailDTO(GoodsEntity e) {
		this.no = e.getGoodsNo();
		this.title = e.getTitle();
		this.content =e.getContent();
		this.price = e.getPrice();
		this.stock = e.getStock();
		//List<ItemListImg>
		imgs=e.getImgs().stream()
				.map(GoodsListImgDTO::new)
				.collect(Collectors.toList());
				
				
		
		this.defImgUrl = e.defImg().getUrl()+e.defImg().getNewName();
	}
	public GoodsDetailDTO(CategoryItemEntity cie) {
		this(cie.getItem());
	}
	
	
}
