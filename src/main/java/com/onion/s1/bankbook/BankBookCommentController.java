package com.onion.s1.bankbook;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onion.s1.board.BbsService;
import com.onion.s1.member.MemberDTO;
import com.onion.s1.util.Pager;

@Controller
@RequestMapping(value = "/bankBookComment/*")
public class BankBookCommentController {

	@Autowired
	private BbsService bankBookCommentService;
	
	@GetMapping("list")
	public ModelAndView getBoardList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();

		
		pager.setPerPage(5L);
		mv.addObject("list", bankBookCommentService.getBoardList(pager));
		mv.setViewName("common/commentList");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(BankBookCommentDTO bankBookCommentDTO, HttpSession session, Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
//		bankBookCommentDTO.setWriter(((MemberDTO)session.getAttribute("member")).getId());
		bankBookCommentDTO.setWriter("qwdfdadmin");
		
		
		mv.addObject("result", bankBookCommentService.setBoardAdd(bankBookCommentDTO, null, null));
		
		
		
		mv.setViewName("common/ajaxResult");
		
		
		return mv;
		
	}
	
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
			
		
		mv.addObject("result", bankBookCommentService.setBoardDelete(bankBookCommentDTO, null));
		mv.setViewName("common/ajaxResult");
		
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookCommentService.setBoardUpdate(bankBookCommentDTO);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		
		return mv;
	}
	
	
	
	
	
	
}
