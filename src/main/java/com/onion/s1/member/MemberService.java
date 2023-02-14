package com.onion.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.setMemberJoin(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		return result;
		
	}
	
	public List<MemberDTO> getMemberList() throws Exception {
		return this.memberDAO.getMemberList();
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		return this.memberDAO.getMemberLogin(memberDTO);
	}
}
