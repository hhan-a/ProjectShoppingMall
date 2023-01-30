package com.green.nowon.domain.entity.board;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.nowon.domain.entity.member.MemberEntity;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity, Long>{

	Optional<BoardEntity> findByMemberName(String name);

	List<BoardEntity> findAllByMemberMno(Long mno);


}
