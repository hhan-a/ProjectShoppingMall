package com.green.nowon.domain.dto.board;

import lombok.Getter;

@Getter
public class PageDTO {
	private int pageTotal;
	private int pageStart;
	private int pageEnd;
	private int pLength;
	
	/**
	 * 
	 * @param page 현재 페이지번호
	 * @param rowTotal 총 게시글 수
	 * @param limit 한 페이지에 보여지는 게시글 수
	 * @param pLength 보여지는 페이지 번호 개수 숫자로 입력
	 */
	public static PageDTO getInstance(int page, int rowTotal, int limit, int pLength) {
		return new PageDTO(page, rowTotal, limit, pLength);
	}
	
	///////////////생성자///////////////
	

	private PageDTO(int page, int rowTotal, int limit, int pLength) {
		this.pLength=pLength;
		pageTotal=rowTotal / limit; //총페이지 수
		if(rowTotal % limit != 0) {
			pageTotal++;
		}
		int pGroup=page/pLength;
		if(page%pLength != 0)  pGroup++; // % 나머지계산
		pageEnd=pGroup*pLength;
		pageStart=pageEnd-pLength+1;
		
		//혹시 마지막 페이지 번호는? 총 페이지 수 보다 클 수 없어요
		if(pageEnd > pageTotal) pageEnd=pageTotal;
	}
}
