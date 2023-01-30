package com.green.nowon.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import lombok.extern.log4j.Log4j2;


//인증이 성공된 이후 이동페이지 설정 (onAuthenticationSuccess 메서드가 처리)
//인증이 필요한 링크를 클릭했을 때 --> 로그인 페이지로 이동시키고, 인증 성공하면 --> 인증이 필요한 링크
//로그인을 직접 클릭한 경우(타겟페이지가 존재하지 않는 경우) --> 이전페이지로 이동 설정
//이전페이지정보가 로그인에서 요청되었을 때 --> root(/) index페이지로

@Log4j2
public class MySuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		clearAuthenticationAttributes(request);
		SavedRequest savedRequest = this.requestCache.getRequest(request, response);
		log.info(" >>>>> savedRequest : "+savedRequest);
		//System.out.println("savedRequest : "+savedRequest);
		//System.out.println("savedRequest_RedirectUrl : "+savedRequest.getRedirectUrl());
		String targetUrl = null;
		if(savedRequest != null) targetUrl = savedRequest.getRedirectUrl();

		//signin 페이지에서 저장한 prevPage 읽어오기
		String prevPage = (String) request.getSession().getAttribute("prevPage");
		if(prevPage != null) request.getSession().removeAttribute("prevPage");
		// Use the DefaultSavedRequest URL
		//security 인증을 위해 로그인 페이지로 보낼때 인증이후 이동할 페이지를 저장한 url
		String url = getDefaultTargetUrl(); // If not set, defaults to /.
		log.info(" >>>>> getDefaultTargetUrl : "+url);
		//System.out.println("getDefaultTargetUrl : "+url);
		if(targetUrl!=null && !targetUrl.contains("/login")) {
			url = targetUrl;
		} else {
			url = prevPage;
		}
		log.info(" >>>>> 인증 완료 후 이동하는 페이지 : "+url);
		//System.out.println("인증 완료 후 이동하는 페이지 : "+url);
		//RedirectStrategy객체 : 최종적으로 페이지 이동을 지원하는 객체
		getRedirectStrategy().sendRedirect(request, response, url);
	}

	

}
