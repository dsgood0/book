package com.khrd.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Object loginId = modelAndView.getModel().get("login");
		if(loginId != null) {
			// session 영역에 Auth키를 만들어서 userid 값을 넣음
			request.getSession().setAttribute("Auth", loginId);
			String dest = (String)request.getSession().getAttribute("dest");
			
			if(dest != null) { // 이동할 목적지가 저장되어 있을 경우
				response.sendRedirect(dest); // dest로 이동
			} else {
				response.sendRedirect(request.getContextPath()+"/book/home"); // home으로 이동
			}
		}
	}

}
