package com.onion.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onion.s1.board.BbsDAO;
import com.onion.s1.board.BbsDTO;
import com.onion.s1.board.BoardDAO;
import com.onion.s1.board.BoardDTO;
import com.onion.s1.board.BoardService;
import com.onion.s1.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		 pager.makeRow();
		 pager.makeNum(qnaDAO.getTotalCount(pager));
		 
		 return qnaDAO.getBoardList(pager);
		 
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {		
		return qnaDAO.setBoardAdd(bbsDTO);
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getBoardDetail(boardDTO);
	}
	
	//reply insert
	public int setReplyAdd(QnaDTO qnaDTO)throws Exception {
		//QnaDTO
		//num : 부모의 글번호
		//writer , title, contents : 답글로 입력한 값
		// ref : null
		// step : null
		// depth : null
		
		//1. 부모의 보를 조회
		QnaDTO parent = (QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		
		//REF : 부모글의 REF값을 사용
		qnaDTO.setRef(parent.getRef());
		
		//STEP : step을 +1 update
		//	조건 ref가 부모의 ref와 같고 부모의 step보다 큰 것들
		//	부모글의 STEP에 +1 
		qnaDTO.setStep(parent.getStep()+1);
		
		//DEPTH : 부모글의 DEPTH에 +1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. STEP Update
		int result = qnaDAO.setStepUpdate(parent);
		
		//3. 답글 insert
		result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result;
		
		
	}
	
	
	
	
}
