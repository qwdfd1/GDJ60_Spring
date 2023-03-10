package com.onion.s1.bankbook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onion.s1.board.BbsDTO;
import com.onion.s1.util.FileManager;
import com.onion.s1.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Autowired
	private FileManager fileManager; 
	
	//Junit 테스트 케이스시 Null이 들어옴
	//API 추가
	@Autowired
	private ServletContext servletContext;
	
	public List<BankBookDTO> getBankBookList(Pager pager) throws Exception {
		
		pager.makeRow();
		pager.makeNum(bankBookDAO.getBankBookCount(pager));
		
		
		
		
		return bankBookDAO.getBankBookList(pager);
	}
	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception { 
			return bankBookDAO.getBankBookDetail(bankBookDTO);
				
	}
	
	public int setBankBookAdd(BankBookDTO bankBookDTO, MultipartFile pic) throws Exception {
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		//1. FIle을 HDD에 저장 경로
		// Project 경로가 아닌 OS가 이용하는 경로
		String realPath = servletContext.getRealPath("resources/upload/bankBook");
		System.out.println(realPath);
		
		
		String fileName = fileManager.fileSave(pic, realPath);
		
		//2. DB에 저장
		BankBookImgDTO bankBookImgDTO = new BankBookImgDTO();
		bankBookImgDTO.setFileName(fileName);
		bankBookImgDTO.setOriName(pic.getOriginalFilename());
		bankBookImgDTO.setBookNumber(bankBookDTO.getBookNumber());
		
		result = bankBookDAO.setBankBookImgAdd(bankBookImgDTO);
		
		return result;
	}
	
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setBankBookUpdate(bankBookDTO);
	}
	
	public int setBankBookDelete(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setBankBookDelete(bankBookDTO);
	}
	

}
