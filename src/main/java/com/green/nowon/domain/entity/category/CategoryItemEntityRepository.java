package com.green.nowon.domain.entity.category;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.nowon.domain.entity.goods.GoodsImgEntity;

@Repository
public interface CategoryItemEntityRepository extends JpaRepository<CategoryItemEntity, Long>{

	List<CategoryItemEntity> findAllByCategoryNo(long cateNo);

}
