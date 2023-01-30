package com.green.nowon.domain.entity.board.faq;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.nowon.domain.dto.board.faq.FaqDTO;

@Repository
public interface FaqEntityRepository extends JpaRepository<FaqEntity, Long> {

	int countAllByDivision(String division);

	Page<FaqEntity> findAllByDivision(String division, Pageable pageable);

	List<FaqDTO> findAllByDivision(String division);

}
