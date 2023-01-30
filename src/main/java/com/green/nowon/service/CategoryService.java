package com.green.nowon.service;

import org.springframework.ui.Model;

public interface CategoryService {

	void add(String[] name);

	void categoryList(Long parentNo, Model model);

	void fistCategory(Model model);

	boolean isReg(String text);

}
