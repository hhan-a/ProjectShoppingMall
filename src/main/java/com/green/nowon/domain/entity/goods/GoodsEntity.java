package com.green.nowon.domain.entity.goods;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.green.nowon.domain.entity.BaseDateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_goods")
@Entity
public class GoodsEntity extends BaseDateEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gno")
	private long goodsNo;
	
	@Column(unique = true, nullable = false) //unique not null
	private String title;
	@Column(nullable = false)
	private int price;
	@Column
	private int stock;

	@Column(nullable = false)
	@Lob
	private String content;
	

	
	@Builder.Default
	@OneToMany(mappedBy = "goods")//지연로딩 기본
	private List<GoodsImgEntity> imgs=new ArrayList<>();
	
	public GoodsImgEntity defImg() {
		for(GoodsImgEntity img:imgs) {
			if(img.isDef()) return img;
			
		}
		return imgs.get(0);//만약에 대표이지미지 없으면 첫번째이미지로 지정
	}

}
