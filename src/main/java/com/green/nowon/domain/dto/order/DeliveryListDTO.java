package com.green.nowon.domain.dto.order;

import com.green.nowon.domain.entity.delivery.DeliveryEntity;

import lombok.Getter;

@Getter
public class DeliveryListDTO {
	
	private long no;
	private boolean base;
	
	private String receivName;//수령자이름
	private String extraAddr;//요청사항
	private String phone;//연락처
	private String postcode;//우편번호
	private String roadAddr;//도로명
	private String jibunAddr;//지번
	private String detailAddr;//상세주소
	
	
	public DeliveryListDTO(DeliveryEntity e) {
		this.base = e.isBase();
		this.receivName = e.getReceivName();
		this.extraAddr = e.getExtraAddr();
		this.phone = e.getPhone();
		this.postcode = e.getPostcode();
		this.roadAddr = e.getRoadAddr();
		this.jibunAddr = e.getJibunAddr();
		this.detailAddr = e.getDetailAddr();
	}
	
}
