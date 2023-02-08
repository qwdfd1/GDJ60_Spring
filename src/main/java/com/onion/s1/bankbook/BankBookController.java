package com.onion.s1.bankbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBankBookList() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankBook/list");
		mv.addObject("bankBookList", bankBookService.getBankBookList());
		
		System.out.println("getbankBookList");
		
		return mv;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankBook/detail");
		mv.addObject("bankBookDTO", bankBookService.getBankBookDetail(bankBookDTO));
		
		System.out.println("getbankBookDetail");
		
		
		
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void setBankBookAdd() throws Exception {
		System.out.println("setbankBookAdd");
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setBankBookAdd(bankBookDTO);
		mv.setViewName("redirect:./list");
		
		System.out.println("getbankBookAdd");
		System.out.println(result != 0);
		
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("bankBookDTO", bankBookService.getBankBookDetail(bankBookDTO));
		mv.setViewName("bankBook/update");

		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		
		int result = bankBookService.setBankBookUpdate(bankBookDTO);
		System.out.println(result != 0);
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		mv.setViewName("redirect:./list");
		
		System.out.println("getbankBookAdd");
		System.out.println(result != 0);
		
		return mv;
		
	}
	
	
}
