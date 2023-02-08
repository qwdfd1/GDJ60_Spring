package com.onion.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onion.s1.util.DBConn;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.onion.s1.member.MemberDAO.";
	
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setMemberJoin", memberDTO);
		
	}
	
	public List<MemberDTO> getMemberList() throws Exception{
		return sqlSession.selectList(NAMESPACE + "getMemberList");
	}
}
