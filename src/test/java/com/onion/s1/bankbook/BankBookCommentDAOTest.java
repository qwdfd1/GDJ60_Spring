package com.onion.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onion.s1.MyTestCase;
import com.onion.s1.board.BbsDTO;
import com.onion.s1.util.Pager;

public class BankBookCommentDAOTest extends MyTestCase {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	
	//list
	@Test
	public void getBoardList() throws Exception {
		
		Pager pager = new Pager();
		pager.setBookNum(421L);
		pager.setKind("writer");
		pager.setSearch("t");
		pager.makeRow();
		//long count = bankBookCommentDAO.getTotalCount(pager);
		List<BbsDTO> ar = bankBookCommentDAO.getBoardList(pager);
		
		
	
		assertEquals(2, ar.size());
	}
	
	
	

}
