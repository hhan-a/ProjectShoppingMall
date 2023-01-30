package com.green.nowon.domain.entity.category;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.green.nowon.domain.entity.goods.GoodsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_category_item")
@Entity
public class CategoryItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	@JoinColumn//category_no
	@ManyToOne
	private CategoryEntity category;
	
	@JoinColumn//item_no
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private GoodsEntity item;

}
