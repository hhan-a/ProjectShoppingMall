package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.board.BoardSaveDTO;

public interface BoardService {

	void save(BoardSaveDTO dto, String string);

	void boardlist(Model model, Long mno);

	void getList(Model model);

}
