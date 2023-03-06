package com.onion.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onion.s1.board.BbsDAO;
import com.onion.s1.board.BbsDTO;
import com.onion.s1.board.BbsService;
import com.onion.s1.util.Pager;

@Service
public class BankBookCommentService implements BbsService {

	@Autowired
	//private BankBookCommentDAO bankBookCommentDAO;
	private BbsDAO bankBookCommentDAO;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(bankBookCommentDAO.getTotalCount(pager));
		
		return bankBookCommentDAO.getBoardList(pager);
	}



	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] files, HttpSession session) throws Exception {
		return bankBookCommentDAO.setBoardAdd(bbsDTO);
	}




	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		return bankBookCommentDAO.setBoardDelete(bbsDTO);
	}



	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		return bankBookCommentDAO.setBoardUpdate(bbsDTO);
	}


	}
	

