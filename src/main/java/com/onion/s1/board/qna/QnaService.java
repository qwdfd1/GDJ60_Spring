package com.onion.s1.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onion.s1.board.BbsDAO;
import com.onion.s1.board.BbsDTO;
import com.onion.s1.board.BoardDAO;
import com.onion.s1.board.BoardDTO;
import com.onion.s1.board.BoardFileDTO;
import com.onion.s1.board.BoardService;
import com.onion.s1.util.FileManager;
import com.onion.s1.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		 pager.makeRow();
		 pager.makeNum(qnaDAO.getTotalCount(pager));
		 
		 return qnaDAO.getBoardList(pager);
		 
	}

	

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] files, HttpSession session) throws Exception {
		int result = qnaDAO.setBoardAdd(bbsDTO);
		
		//file HDD에 저장
		//파일저장 노션 확인
		
		String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
		System.out.println(realPath);
		
		for (MultipartFile multipartFile : files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(multipartFile, realPath);
			
			//DB INSERT
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			
			result = qnaDAO.setBoardFileAdd(boardFileDTO);
			
		}
		
		
		//
		
		return result;
	}



	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session, Long[] fileNums)
			throws Exception {
		//qna Update
		int result = qnaDAO.setBoardUpdate(bbsDTO);
		
		//qnaFiles Delete
		if(fileNums != null) {
			for(Long fileNum : fileNums) {
				qnaDAO.setBoardFileDelete(fileNum);
			}
		}
	
		
		//qnaFiles Update
		
		//file HDD에 저장
		//파일저장 노션 확인
		
		String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
		System.out.println(realPath);
		
		for (MultipartFile multipartFile : multipartFiles) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(multipartFile, realPath);
			
			//DB INSERT
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			
			result = qnaDAO.setBoardFileAdd(boardFileDTO);
			
		}
		
		
		
		return result;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		List<BoardFileDTO> ar = qnaDAO.getBoardFileList(bbsDTO);
		int result = qnaDAO.setBoardDelete(bbsDTO);
		
		if(result>0) {
			
			String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
			
			for (BoardFileDTO boardFileDTO : ar) {
				boolean check = fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
			
		}
		
		return result;
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



	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return qnaDAO.getBoardFileDetail(boardFileDTO);
	}
	
	public int setBoardFileDelete(Long fileNum) throws Exception {
		//HDD에 파일 삭제
		return qnaDAO.setBoardFileDelete(fileNum);
	}
	
	
	
	
	
	
}
