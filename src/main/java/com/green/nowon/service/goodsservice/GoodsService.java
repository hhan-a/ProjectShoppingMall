package com.green.nowon.service.goodsservice;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.GoodsInsertDTO;
import com.green.nowon.domain.dto.GoodsListDTO;

public interface GoodsService {

	Map<String, String> fileTempUp(MultipartFile gimg);

	void save(GoodsInsertDTO dto);
	
	void findAll(Model model);	

	void list(Model model);

	void goodsOfCategory(long cateNo, Model model);

	void detail(long no, Model model);

	void update(GoodsListDTO dto);

	void delete(long no);


}
