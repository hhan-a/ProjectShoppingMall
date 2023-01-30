package com.green.nowon.domain.entity.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "foo_sale")
@Entity
public class SaleEntity {
	
	@Id
	@Column(unique = true ,nullable = false)
	private long sale;
	
	@Column(nullable = false)
	private String startDate;
	
	@Column(nullable = false)
	private String endDate;
	
	@Column(nullable = false)
	private long saleRate;
	
	
}
