package com.onion.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onion.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase{
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookListTest() throws Exception {
					
//		List<BankBookDTO> bankBookDTOs = bankBookDAO.getBankBookList();
//		assertNotEquals(0, bankBookDTOs.size());
	}
	
//	@Test
//	public void getBankBookDetailTest() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNumber(3L);
//		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
//		
//		assertNull(bankBookDTO);
//	}
	
	@Test
	public void setBankBookAddTest() throws Exception {
		for(int i=0; i<30; i++) {
			Random r = new Random();
			double d = r.nextDouble();//0.1234
			int num = (int)(d*1000);
			d = num/100.0;
			
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("진규적금"+i);
			bankBookDTO.setBookRate(d);
			bankBookDTO.setBookSale(1);
			bankBookDTO.setBookDetail("오조오억"+i);
			
			bankBookDAO.setBankBookAdd(bankBookDTO);
		}
		 
		
//		assertNotEquals(0, result);
		
	}
	
	@Test
	public void setBankBookDeleteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(4L);
		
		int result = bankBookDAO.setBankBookDelete(bankBookDTO);
		
		assertNotEquals(0, result);
		
		
	}
	
	

}
