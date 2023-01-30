package com.green.nowon.domain.entity.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.nowon.domain.entity.goods.GoodsEntity;

public interface CartItemEntityRepository extends JpaRepository<CartItemEntity, Long>{

	Optional<CartItemEntity> findByCnoAndGno(CartEntity cno, GoodsEntity itemNo);
	
	List<CartItemEntity> findByCnoMnoEmail(String email);
}
