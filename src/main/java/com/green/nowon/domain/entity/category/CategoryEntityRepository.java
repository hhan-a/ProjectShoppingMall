package com.green.nowon.domain.entity.category;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long>{

	Optional<CategoryEntity> findByParentNoAndName(Object object, String string);

	List<CategoryEntity> findByParentNoOrderByNameAsc(Long parentNo);

	Optional<CategoryEntity> findByParentNoNullAndName(String text);


}
