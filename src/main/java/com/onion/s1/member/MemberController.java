package com.onion.s1.member;

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
	public void memberLogin() {
		System.out.println("Member Login");
		
	}
	
	@RequestMapping(value = "memberPage")
	public void memberPage(MemberDTO memberDTO) {
		System.out.println("Member Mypage");
		
	}
	
	@RequestMapping(value ="memberList")
	public ModelAndView memberList() throws Exception {
		System.out.println("Member List");
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberDTOs", memberService.getMemberList());
		mv.setViewName("/member/memberList");
		
		return mv;
		
	}

}
