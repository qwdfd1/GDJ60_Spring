package com.onion.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onion.s1.MyTestCase;



public class MemberDAOTest extends MyTestCase {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void setMemberJoinTest() throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("aaa");
		memberDTO.setPw("aaa");
		memberDTO.setName("testName");
		memberDTO.setPhone("010555");
		memberDTO.setEmail("test@email.com");
		memberDTO.setAddress("영등포");
		
		int result = memberDAO.setMemberJoin(memberDTO);
		System.out.println(result);
		assertEquals(1, result);
		

	}

}
