package com.green.nowon.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.green.nowon.domain.entity.goods.GoodsEntity;
import com.green.nowon.domain.entity.goods.GoodsImgEntity;
import com.green.nowon.utils.MyFileUtils;

import lombok.Data;

@Data
public class GoodsInsertDTO {
	
	private long[] categoryNo;
	
	private String title;
	private String content;
	private int price;
	private int stock;
	
	private String[] newName;
	private String[] orgName;
	
	
	public List<GoodsImgEntity> toGoodsImg(GoodsEntity goods, String url){
		List<GoodsImgEntity> imgs=new ArrayList<>();
		for(int i=0; i<orgName.length;i++) {
			if(orgName[i].equals("")||orgName[i]==null)continue;
			boolean defImg=false;
			if(i==0) defImg=true;
			GoodsImgEntity gent=GoodsImgEntity.builder()
					.url(url)
					.orgName(orgName[i])
					.newName(newName[i])
					.def(defImg)
					.goods(goods)
					.build();
			
			imgs.add(gent);
		}
		//temp폴더의 상위폴더인 upload로 이동
		MyFileUtils.moveUploadLocFormTemp(newName, url);
		return imgs;
	}
	
	public GoodsEntity toGoodsEntity() {
		return GoodsEntity.builder()
				.title(title).content(content).price(price).stock(stock)
				.build();
	}
}
