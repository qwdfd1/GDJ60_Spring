package com.onion.s1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
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
	public void getMemberLogin() {
		System.out.println("Member Login");
		
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		
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
