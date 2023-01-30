package com.green.nowon.domain.entity.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.green.nowon.domain.entity.goods.GoodsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foo_cartItem")
@Entity
public class CartItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cino;
	
	@ManyToOne
	@JoinColumn(name = "cno")
	private CartEntity cno;
	
	@ManyToOne
	@JoinColumn(name = "gno")
	private GoodsEntity gno;
	
	
	@Column(nullable = false)
	private int count;
	
	@Column(nullable = false)
	private boolean selected;
	
	public CartItemEntity updateQuantity(int count) {
		this.count += count;
		return this;
	}

}
