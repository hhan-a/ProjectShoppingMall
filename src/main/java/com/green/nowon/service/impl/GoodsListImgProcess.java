package com.green.nowon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.entity.goods.GoodsImgEntity;
import com.green.nowon.domain.entity.goods.GoodsImgEntityRepository;
import com.green.nowon.service.GoodsListImgService;

@Service
public class GoodsListImgProcess implements GoodsListImgService {

	@Autowired
	private GoodsImgEntityRepository repo;

	@Override
	public void findAll(Model model) {
		List<GoodsImgEntity> list=repo.findAll();
		
		model.addAttribute("img",list);
	}
}