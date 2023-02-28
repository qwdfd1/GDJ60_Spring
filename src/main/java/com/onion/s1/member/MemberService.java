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
		//memberDTO : Client에서 입력한 ID, PW
		//result : ID와 일치하는 모든 정보
		MemberDTO result = memberDAO.getMemberLogin(memberDTO);
		
		//pw check
		if(result != null && memberDTO.getPw().equals(result.getPw())) {
			memberDTO.setPw(null);
			memberDTO.setRoleDTO(result.getRoleDTO());
			return memberDTO;
		}else {
			return null;
		}
		
	}
	
	public MemberDTO getMemberPage(MemberDTO memberDTO) throws Exception {
		return this.memberDAO.getMemberLogin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return this.memberDAO.setMemberUpdate(memberDTO);
	}
	

}
