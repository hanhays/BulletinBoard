package com.naver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			if(session.getAttribute("login") != null) {
				session.removeAttribute("login");
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		Object login = modelAndView.getModelMap().get("login");
		
		if (login != null) {
			session.setAttribute("login", login);
			response.sendRedirect("/");
		} else {
			response.sendRedirect("/user/login");
		}
	}
}
