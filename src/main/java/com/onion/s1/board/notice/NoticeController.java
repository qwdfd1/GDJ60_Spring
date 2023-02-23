package com.onion.s1.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onion.s1.board.BbsService;
import com.onion.s1.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private BbsService noticeService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", noticeService.getBoardList(pager));
		mv.setViewName("board/list");

		return mv; 
		
	}
}
