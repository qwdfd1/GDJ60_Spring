package com.onion.s1.bankbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onion.s1.board.BbsService;
import com.onion.s1.util.Pager;

@Controller
@RequestMapping(value = "/bankBookComment/*")
public class BankBookCommentController {

	@Autowired
	private BbsService bankBookCommentService;
	
	@RequestMapping(value = "list" , method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", bankBookCommentService.getBoardList(pager));
		mv.setViewName("board/list");
		
		return mv;
	}
	
}
