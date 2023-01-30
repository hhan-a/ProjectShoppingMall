package com.green.nowon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.entity.category.CategoryEntity;
import com.green.nowon.domain.entity.category.CategoryEntityRepository;
import com.green.nowon.service.CategoryService;



@Service
public class CategoryServiceProcess implements CategoryService {

	@Autowired
	CategoryEntityRepository repo;
	
	@Override
	public void add(String[] names) {
		//orelseget은 null일때만 실행
		//orelse는 null이 아니더라도 실행
		CategoryEntity cate1=repo.findByParentNoAndName(null,names[0])
				.orElseGet(()->repo.save(CategoryEntity.builder()
						.name(names[0])
						.depth(1)
						.parent(null)
						.build()));


		
		repo.findByParentNoAndName(cate1.getNo(), names[1])
				.orElseGet(()->repo.save(CategoryEntity.builder()
						.name(names[1])
						.depth(2)
						.parent(cate1)
						.build()));
	}

	@Override
	public void categoryList(Long parentNo, Model model) {
		if(parentNo.intValue()==0)parentNo=null;//null 은 1차카테고리
		model.addAttribute("list", repo.findByParentNoOrderByNameAsc(parentNo));
		
	}

	@Override
	public void fistCategory(Model model) {
		model.addAttribute("list", repo.findByParentNoOrderByNameAsc(null));
	}

	@Override
	public boolean isReg(String text) {
		Optional<CategoryEntity> result= repo.findByParentNoNullAndName(text);
		if(result.isEmpty())
			return true;
		return false;
	}

}
