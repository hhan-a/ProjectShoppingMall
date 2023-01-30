package com.green.nowon.domain.entity.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
//@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foo_goods_img")
@Entity
public class GoodsImgEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ino;
	@Column(nullable = false)
	private String url;
	@Column(nullable = false)
	private String orgName;
	@Column(nullable = false)
	private String newName;
	
	private boolean def;
	
	@JoinColumn
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private GoodsEntity goods;
	

}