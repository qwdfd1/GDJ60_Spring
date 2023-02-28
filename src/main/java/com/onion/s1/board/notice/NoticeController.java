package com.onion.s1.board.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.onion.s1.board.BbsService;
import com.onion.s1.board.BoardDTO;
import com.onion.s1.board.BoardFileDTO;
import com.onion.s1.member.MemberDTO;
import com.onion.s1.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@ModelAttribute(name = "boardName")
	public String getBoardName() {
		
		return "notice";
	}
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", noticeService.getBoardList(pager));
		mv.setViewName("board/list");

		return mv; 
		
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(NoticeDTO noticeDTO, MultipartFile [] files, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setBoardAdd(noticeDTO, files, session);
		
		String message = "등록 실패";
		
		if(result > 0) {
			message = "글이 등록되었습니다";
		}
		
		 mv.addObject("result", message);
		 mv.addObject("url", "./list");
		 mv.setViewName("common/result");
		 
		return mv;
		
		
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.addObject("dto", noticeService.getBoardDetail(noticeDTO));
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("boardFile", noticeService.getBoardFileDetail(boardFileDTO));
		mv.setViewName("fileDownView");
		
		return mv;
	}
	
}
