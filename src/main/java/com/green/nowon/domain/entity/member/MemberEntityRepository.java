package com.green.nowon.domain.entity.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long>{

	Optional<MemberEntity> findByEmail(String username);

	Optional<MemberEntity> findByName(String name);

	List<MemberEntity> findAll();

	void deleteByMno(long mno);


}
