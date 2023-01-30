package com.green.nowon.domain.dto.order;

import com.green.nowon.domain.entity.delivery.DeliveryEntity;

import lombok.Setter;

@Setter
public class DeliveryInfoDTO {
	
	private String receivName;
	private String postcode;
	private String roadAddr;
	private String jibunAddr;
	private String detailAddr;
	private String phone;
	private String extraAddr;
	
	
	public DeliveryEntity toEntity() {
		return DeliveryEntity.builder()
				.receivName(receivName)//수령자이름
				.postcode(postcode)//우편번호
				.roadAddr(roadAddr)//도로명주소
				.jibunAddr(jibunAddr)//지번주소
				.detailAddr(detailAddr)//상세주소 ex)xxx동xxx호 
				.phone(phone)//연락처
				.extraAddr(extraAddr)//부재중시 수령장소
				.build();
	}

}
