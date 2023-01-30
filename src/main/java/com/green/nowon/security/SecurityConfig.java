package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	MyUserDetailsService customUserDetailsService() {
		return new MyUserDetailsService();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize
					.antMatchers("/common/**","/category/**","/member/login-check","/list/**").permitAll()
					.antMatchers("/").permitAll()
					.antMatchers("/images/**","/js/**","/css/**","/webjars/**").permitAll()
					.antMatchers("/hello/**","/message/**","/topic/**","/app/**","/my-websocket/**").permitAll()
					.antMatchers("/goods/**","/signup","/board/**").permitAll()
					.antMatchers("/admin/**","/delete/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin(formLogin->formLogin
					.usernameParameter("email")
					.passwordParameter("pass")
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.successHandler(mySuccessHandler())
					.permitAll()
			)
			.csrf(csrf->csrf.disable());
			
		return http.build();
	}
	
	@Bean
	public AuthenticationSuccessHandler mySuccessHandler() {
		return new MySuccessHandler();
	}
}
