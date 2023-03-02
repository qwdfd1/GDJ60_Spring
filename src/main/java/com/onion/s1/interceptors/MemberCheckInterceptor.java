package com.onion.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{

	// Controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// return이 true라면 다음 Controller로 진행
		// return이 false라면 다음 Contoller로 진행 X
		System.out.println("Member Check Interceptor");
		
		if(request.getSession().getAttribute("member") != null) {
			return true;
		}
		else {
			System.out.println("유저정보 없음");
			
			//1. Forward Jsp
//			request.setAttribute("result", "권한이 없습니다");
//			request.setAttribute("url", "../member/memberLogin");
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
//			view.forward(request, response);
			
			//2. Redirect
			response.sendRedirect("../../../../../member/memberLogin");
			
			return false;
		}
		
		
	}


	
	
}
