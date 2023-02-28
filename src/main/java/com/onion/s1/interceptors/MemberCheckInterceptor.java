package com.onion.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Controller 진입전
		// return이 true라면 다음 Controller로 진행
		// return이 false라면 다음 Contoller로 진행 X
		System.out.println("Controller 진입 전 체크");
		
		if(request.getSession().getAttribute("member") != null) {
			return true;
		}
		else {
			request.setAttribute("result", "권한이 없습니다");
			request.setAttribute("url", "../member/memberLogin");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			return false;
		}
		
		
	}


	
	
}
