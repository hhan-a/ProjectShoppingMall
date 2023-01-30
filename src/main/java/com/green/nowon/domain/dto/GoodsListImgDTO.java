package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.goods.GoodsImgEntity;

import lombok.Getter;

@Getter
public class GoodsListImgDTO {
	private long no;
	private String orgName;
	private String newName;
	private String url;
	private boolean defImg;
	
	//편의필드
	private String imgUrl;
	
	public GoodsListImgDTO(GoodsImgEntity e) {
		this.no = e.getIno();
		this.orgName = e.getNewName();
		this.newName = e.getNewName();
		this.url = e.getUrl();
		this.defImg = e.isDef();
		
		this.imgUrl=url+newName;
	}
	
	
}
