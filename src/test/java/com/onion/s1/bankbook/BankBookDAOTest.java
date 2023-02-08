package com.onion.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onion.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase{
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookListTest() throws Exception {
		List<BankBookDTO> bankBookDTOs = bankBookDAO.getBankBookList();
		assertNotEquals(0, bankBookDTOs.size());
	}
	
	@Test
	public void getBankBookDetailTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(3L);
		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
		
		assertNull(bankBookDTO);
	}
	
	@Test
	public void setBankBookAddTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(4L);
		bankBookDTO.setBookName("혼공자");
		bankBookDTO.setBookRate(2.24);
		bankBookDTO.setBookSale(1);
		bankBookDTO.setBookDetail("혼자 공부하는 자바");
		
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		assertNotEquals(0, result);
		
	}
	
	@Test
	public void setBankBookDeleteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(4L);
		
		int result = bankBookDAO.setBankBookDelete(bankBookDTO);
		
		assertNotEquals(0, result);
		
		
	}
	
	

}
