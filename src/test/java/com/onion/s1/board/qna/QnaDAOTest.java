package com.onion.s1.board.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onion.s1.MyTestCase;
import com.onion.s1.util.Pager;

public class QnaDAOTest extends MyTestCase{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	//@Test
	public void getTotalCountTest() throws Exception {
		Pager pager = new Pager();
		pager.setKind("title");
		pager.setSearch("석");
		long result = qnaDAO.getTotalCount(pager);
		
		assertNotEquals(0, result);

				
	}
	
	//@Test
	public void getBoardListTest() throws Exception {
		Pager pager = new Pager();
		pager.setKind("title");
		pager.setSearch("석");
		long result = qnaDAO.getTotalCount(pager);
		
		assertNotEquals(0, result);

	}
	
	//@Test
	public void setBoardAdd() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("환불 요청");
		qnaDTO.setWriter("석주");
		qnaDTO.setContents("너무 작아용");
		
		assertEquals(1, qnaDAO.setBoardAdd(qnaDTO)); 
		
		
	}
	


}
