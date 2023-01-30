package com.green.nowon.service.goodsservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.GoodsDetailDTO;
import com.green.nowon.domain.dto.GoodsInsertDTO;
import com.green.nowon.domain.dto.GoodsListDTO;

import com.green.nowon.domain.entity.category.CategoryEntity;
import com.green.nowon.domain.entity.category.CategoryEntityRepository;
import com.green.nowon.domain.entity.category.CategoryItemEntity;
import com.green.nowon.domain.entity.category.CategoryItemEntityRepository;

import com.green.nowon.domain.entity.goods.GoodsEntity;
import com.green.nowon.domain.entity.goods.GoodsEntityRepository;
import com.green.nowon.domain.entity.goods.GoodsImgEntityRepository;
import com.green.nowon.utils.MyFileUtils;

@Service
public class GoodsServiceProcess implements GoodsService {
	
	@Value("${file.location.temp}")
	private String tempUp;
	
	@Value("${file.location.upload}")
	private String upload;
	
	@Autowired
	GoodsEntityRepository grepo;//상품
	@Autowired
	GoodsImgEntityRepository girepo;//상품이미지
	@Autowired
	CategoryItemEntityRepository cateItemRepo;//카테고리상품연계
	@Autowired
	CategoryEntityRepository cateRepo;//카테고리
	
	
	
	List<CategoryEntity> cates;
	
	
	@Override
	public Map<String, String> fileTempUp(MultipartFile gimg) {
		return MyFileUtils.fileUpload(gimg, tempUp);
	}

	@Override
	public void save(GoodsInsertDTO dto) {
		long[] categoryNo=dto.getCategoryNo();
		
		GoodsEntity entity=grepo.save(dto.toGoodsEntity());
		
		for(long no:categoryNo) {
			cateItemRepo.save(CategoryItemEntity.builder()
					.item(entity)
					.category(cateRepo.findById(no).get())
					.build());
		}
		
		dto.toGoodsImg(entity, upload).forEach(girepo::save);
	}

	
	@Transactional
	@Override
	public void list(Model model) {
		
		model.addAttribute("list", grepo.findAll().stream()
				.map(GoodsListDTO::new).collect(Collectors.toList()));
		
	}
	
	//재귀메서드
	private void categoryList(CategoryEntity ca) {
		if(ca==null)return;
		cates.add(ca);
		categoryList(ca.getParent());
	}
	
	@Transactional
	@Override
	public void goodsOfCategory(long cateNo, Model model) {
		//카테고리에 해당하는 상품들모두
		cates=new ArrayList<>();
		categoryList(cateRepo.findById(cateNo).get());
		
		model.addAttribute("cates", cates);
		
		model.addAttribute("list", cateItemRepo.findAllByCategoryNo(cateNo)
				.stream()
				.map(GoodsListDTO::new)
				.collect(Collectors.toList()));
	}


	@Autowired
	private GoodsEntityRepository repo;

	@Override
	public void findAll(Model model) {
		List<GoodsListDTO> result=repo.findAll().stream()
				.map(GoodsListDTO::new).collect(Collectors.toList());
		
		model.addAttribute("list", result);
	}

	
	@Transactional
	@Override
	public void detail(long no, Model model) {
		model.addAttribute("goods",grepo.findById(no)
				.map(GoodsDetailDTO::new)
				.orElseThrow());
		
	}

	@Override
	public void update(GoodsListDTO dto) {
		grepo.save(GoodsEntity.builder()
				.content(dto.getContent())
				.title(dto.getTitle())
				.price(dto.getPrice())
				.stock(dto.getStock())
				.goodsNo(dto.getNo())
				.build());
	}

	@Override
	public void delete(long no) {
		grepo.deleteById(no);
		
	}


	

	


}
