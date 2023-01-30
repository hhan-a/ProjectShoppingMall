package com.green.nowon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.nowon.domain.entity.member.MemberEntityRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberEntityRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new MyUserDetails(repo.findByEmail(username)
				.orElseThrow(()->new UsernameNotFoundException("존재하지 않는 이메일")));
	}


}
