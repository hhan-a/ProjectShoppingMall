package com.green.nowon.domain.entity.board.faq;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Division {
	
	USE("DIVISION_USE"),
	MEMBER("DIVISION_MEMBER"),
	ORDER("DIVISION_ORDER"),
	DELIVERY("DIVISION_DELIVERY"),
	CANCEL("DIVISION_CANCEL"),
	SERVICE("DIVISION_SERVICE");

	private final String division;

}
