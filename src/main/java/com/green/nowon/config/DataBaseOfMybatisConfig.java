package com.green.nowon.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class DataBaseOfMybatisConfig {
	
	
	 @Bean
     public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		 //System.out.println("dataSource :"+dataSource);
		 //jpa 때문에 자동으로 설정된 DataSource 사용가능
		 SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
		 ssfb.setDataSource(dataSource);
		 System.out.println("MapUnderscoreToCamelCase:"+ mybatisConfig().isMapUnderscoreToCamelCase());
		 log.info(">>>>MapUnderscoreToCamelCase:"+ mybatisConfig().isMapUnderscoreToCamelCase());
		 ssfb.setConfiguration(mybatisConfig());
		 
         return ssfb.getObject();
     }
	 
	 @Bean
	 @ConfigurationProperties(prefix = "mybatis.configuration")
	 public org.apache.ibatis.session.Configuration mybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}

	@Bean
	 public SqlSessionTemplate sqlSessionTemplate(DataSource dataSource) throws Exception {
		 return new SqlSessionTemplate( sqlSessionFactory(dataSource) );
	 }


}