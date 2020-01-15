package com.khrd.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute("Auth");
		if(auth == null) { // 로그인 전
			// 강제 이동 전에 내 주소와 query를 저장시킴
			saveDest(request);
			//로그인 화면으로 강제 이동
			response.sendRedirect(request.getContextPath() + "/member/login");
			return false; // Controller 진입이 막힘
		}

		return super.preHandle(request, response, handler);
	}
	
	private void saveDest(HttpServletRequest request) {
		// http://localhost:8080/ex01/sboard/readPage?bno=1607&page=5&searchType=&keyword=
		String uri = request.getRequestURI(); // 이동 주소 : sboard/readPage
		String query = request.getQueryString(); // 매개변수와 값 : bno=1607&page=5&searchType=&keyword=
		
		if(query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		
		// post는 이 방법 사용 불가, get일 때만 가능
		if(request.getMethod().equalsIgnoreCase("get")) {
			// dest : sboard/readPage?bno=1607&page=5&searchType=&keyword=
			request.getSession().setAttribute("dest", uri + query);
		}
	}

}
