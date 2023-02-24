package com.onion.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onion.s1.board.BbsService;
import com.onion.s1.board.BoardDTO;
import com.onion.s1.util.Pager;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute (name = "boardName")
	public String getBoardName() {
		return "qna";
	}
	
	//Pager를 ModelAndView에 추가해주지 않아도 jsp로 객체가 전달된다
	//매개변수 지정 시 앞에 자동으로 @ModelAttribute가 붙는다
	//즉 매개변수로 지정시 자동으로 Model의 속성에 담겨서 전달된다
	//속성명을 지정하지 않으면 클래스명의 앞글자를 소문자로 바꾸어 속성명으로 들어간다
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", qnaService.getBoardList(pager));
		mv.setViewName("/board/list");
		
		return mv;
		
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setBoardAdd(qnaDTO);
		String msg = "등록 실패";		
		
		if(result > 0) {
			msg = "글이 등록되었습니다";
		}
		
		mv.addObject("result", msg);
		mv.addObject("url", "./list");
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", qnaService.getBoardDetail(qnaDTO));
		
		
		
		mv.setViewName("board/detail");
		
		return mv;
		
	}
	
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/reply");
		mv.addObject("dto", qnaDTO);
		
		return mv;
	}
	
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setReplyAdd(qnaDTO);
		String msg = "등록 실패";		
		
		if(result > 0) {
			msg = "글이 등록되었습니다";
		}
		
		mv.addObject("result", msg);
		mv.addObject("url", "./detail?num="+qnaDTO.getNum());
		mv.setViewName("common/result");
		
		return mv;
	}
	
}
