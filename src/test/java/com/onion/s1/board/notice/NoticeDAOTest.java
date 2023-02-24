package com.onion.s1.board.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onion.s1.MyTestCase;
import com.onion.s1.board.BbsDTO;
import com.onion.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase{

	@Autowired
	NoticeDAO noticeDAO;
	
	

	@Test
	public void getTotalCount() throws Exception {
		
		Pager pager = new Pager();
		pager.setKind("title");
		pager.setSearch("석");
		
		long result = noticeDAO.getTotalCount(pager);
		
		assertNotEquals(0, result);		
	}
	
	@Test
	public void setBoardAdd() throws Exception {
		
		NoticeDTO noticeDTO = new NoticeDTO();
		
		noticeDTO.setTitle("SeokJoo1");
		noticeDTO.setWriter("석주");
		noticeDTO.setContents("석주가 씀");
		
		int result = noticeDAO.setBoardAdd(noticeDTO);
		
		assertEquals(1, result);
	}

}
