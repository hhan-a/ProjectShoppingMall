package com.green.nowon.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.board.faq.FaqDTO;

public interface FaqService {

	void listForAjax(ModelAndView mv, String division, int page);

	void getList(Model model);



}
