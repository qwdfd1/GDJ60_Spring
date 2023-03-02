package com.onion.s1.interceptors;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.onion.s1.board.BoardDTO;
import com.onion.s1.board.notice.NoticeDAO;
import com.onion.s1.board.notice.NoticeDTO;
import com.onion.s1.board.qna.QnaDAO;
import com.onion.s1.member.MemberDTO;

@Component
public class OwnerCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private NoticeDAO noticeDAO;

	
	//update와 delete와 같이 사용하기 위해서 posthandle이 아닌 prehandle에 작성한다
	//delete는 DB처리를 하기전에 검증을 해야하기 때문에 preHandle에서 작업한다
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Long num  = Long.parseLong(request.getParameter("num"));
		
		System.out.println("URI : " + request.getRequestURI());
		System.out.println("PathInfo : " + request.getPathInfo());
		System.out.println("ServletPath : " + request.getServletPath());
		
		String uri = request.getRequestURI();
		
		uri = uri.substring(1,uri.lastIndexOf("/"));
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(num);
		
		if(uri.equals("notice")) {
			boardDTO = noticeDAO.getBoardDetail(boardDTO);
		}
		else {
			boardDTO = qnaDAO.getBoardDetail(boardDTO);
		}
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			
			request.setAttribute("result", "작성자만 이용 가능합니다.");
			request.setAttribute("url", "./list");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			return false;
		}
		
		
		
		
		return true;
	}
	
//	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Owner Check Interceptor");
//		//1. 로그인
//		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
//		
//		//2. BoardDTO
//		Map<String, Object> map = modelAndView.getModel();
//		BoardDTO boardDTO = (BoardDTO)map.get("dto");
////		map.keySet().iterator();
//		
//		//3. Check
//		// 작성자와 로그인 된 사용자가 같지 않을 경우 
//		if(memberDTO == null || !memberDTO.getId().equals(boardDTO.getWriter())) {
//			modelAndView.setViewName("common/result");
//			modelAndView.addObject("result", "작성자만 이용가능합니다");
//			modelAndView.addObject("url", "./list");
//			
//		}
//		
//		
//		
//		
//	}
	
	
	
	
}
