package com.onion.s1.board.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onion.s1.MyTestCase;
import com.onion.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase{

	@Autowired
	NoticeDAO noticeDAO;
	
	
	//에러 확인
	@Test
	public void getTotalCount() throws Exception {
		
		Pager pager = new Pager();
		pager.setKind("title");
		pager.setSearch("석");
		
		long result = noticeDAO.getTotalCount(pager);
		
		assertNotEquals(0, result);
		
		
	}

}
