package com.onion.s1.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.onion.s1.board.BbsDTO;
import com.onion.s1.board.BbsService;
import com.onion.s1.board.BoardDTO;
import com.onion.s1.board.BoardFileDTO;
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
		
//		//REST API 방식 
//		RestTemplate restTemplate = new RestTemplate();
//		
//		//URL, Method, Parameter, header
//		
//		
//		//Header
//		HttpHeaders headers = new HttpHeaders();
//		//1. header.add("header명", "header값");
//		headers.add("Content-Type", "application/x-www-form-urlencoded");
//		//2. headers.set헤더명("header값")
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		
//		
//		//Parameter(post)
//		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		params.add("파라미터명", "파라미터값");
//		params.add("grant_type", "authorization_code");
//		params.add("client_id", "${REST_API_KEY}");
//		
//		//header, params 하나의 객체로 생성
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(params, headers);
//		
//		//URL, Method 
//		String result = restTemplate.getForObject("https://dummyjson.com/products/1", String.class, request);
		
		return mv;
		
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, MultipartFile [] addFiles, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setBoardAdd(qnaDTO, addFiles, session);
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
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		
		
		String msg = "삭제 실패";
		
		int result = qnaService.setBoardDelete(bbsDTO, session);
		
		if(result > 0) {
			msg = "삭제 성공";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("result", msg);
		mv.addObject("url", "./list");
		
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("boardFile", qnaService.getBoardFileDetail(boardFileDTO));
		mv.setViewName("fileDownView");
		
		return mv;
		
	}
	
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getBoardDetail(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO, MultipartFile [] addFiles, HttpSession session, Long [] fileNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("FileNum 출력");
		int result = qnaService.setBoardUpdate(boardDTO, addFiles, session, fileNum);
		
		String msg = "수정 실패";
		
		if(result > 0) {
			msg = "수정 성공";
		}
		
		mv.setViewName("common/result");
		mv.addObject("result", msg);
		mv.addObject("url", "./detail?num="+boardDTO.getNum());
		
		
		return mv;
	}
	
//	-------------------------------------------------------------------------------
	
	@PostMapping("boardFileDelete")
	public ModelAndView setBoardFileDelete(Long fileNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardFileDelete(fileNum);
		
		
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		
		return mv;
	}
	
	
	
}
