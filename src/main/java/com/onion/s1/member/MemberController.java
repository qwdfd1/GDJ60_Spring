package com.onion.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boolean check = memberService.getMemberIdCheck(memberDTO);
		mv.addObject("result", check);
		mv.setViewName("common/ajaxResult");
		
		return mv;
		
		
	}
	
	@RequestMapping(value = "memberJoin")
	public void setMemberJoin() throws Exception {
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String setMemberJoin(MemberDTO memberDTO) throws Exception{
		System.out.println("Member Join");
				
		int result = memberService.setMemberJoin(memberDTO);
		System.out.println(result != 0);
		
		return "redirect:./memberList";
	}
	
	@RequestMapping(value = "memberLogin")
	public ModelAndView getMemberLogin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		Cookie [] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println("Cookie Name : " + cookie.getName());
			System.out.println("Cookie Value : " + cookie.getValue());
			System.out.println("Cookie Domain : " + cookie.getDomain());
			System.out.println("Cookie Path : " + cookie.getPath());
			System.out.println("------------------------------------------");
			if(cookie.getName().equals("rememberId")) {
				mv.addObject("rememberId", cookie.getValue());
				break;
			}
		}
		System.out.println("Member Login");
		
		mv.setViewName("/member/memberLogin");
		return mv;
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpSession session, HttpServletResponse response, String remember) throws Exception {
		
		if(remember != null && remember.equals("remember") ) {
			Cookie cookie = new Cookie("rememberId", memberDTO.getId());
			cookie.setMaxAge(60*60*24*7); // 초 단위
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("rememberId", null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		memberDTO = memberService.getMemberLogin(memberDTO);
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);		
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		
		
		return mv;
	}
	
	
	@RequestMapping(value ="memberList")
	public ModelAndView memberList() throws Exception {
		System.out.println("Member List");
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberDTOs", memberService.getMemberList());
		mv.setViewName("/member/memberList");
		
		return mv;
		
	}
	
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		session.invalidate();
		
		return mv;
	}
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session) throws Exception {
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", memberService.getMemberPage((MemberDTO)session.getAttribute("member")));
		mv.setViewName("/member/memberPage");
		
		return mv;
	}
	
	
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", memberService.getMemberPage((MemberDTO)session.getAttribute("member")));
		
		mv.setViewName("/member/memberUpdate");
		
		return mv;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		memberDTO.setId(((MemberDTO)session.getAttribute("member")).getId());
		int result = memberService.setMemberUpdate(memberDTO);
		
//		if(result > 0) {
//			session.setAttribute("memberDTO", memberService.getMemberPage(memberDTO));
//		}
		
		mv.setViewName("redirect:./memberPage");
		return mv; 
	}
	
	@RequestMapping(value = "memberAgree", method = RequestMethod.GET)
	public void setMemberAgree() throws Exception {
		
	}

}
