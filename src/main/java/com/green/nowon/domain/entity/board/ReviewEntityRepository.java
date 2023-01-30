package com.green.nowon.domain.entity.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewEntityRepository extends JpaRepository<ReviewEntity, Long> {

}
