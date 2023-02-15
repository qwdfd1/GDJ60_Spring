package com.onion.s1.util;

public class Pager {
	
	//하나의 페이지의 출력할 Row의 갯수
	private Long perPage;
	
	//사용자가 보고싶은 페이지 번호
	private Long page;
	
	//Table에서 조회할 시작 Row번호
	private Long startRow;
	
	//Table에서 조회할 끝 Row번호
	private Long lastRow;
	
	//현재블럭에서 보여줄 첫 번호
	private Long startNum;
	
	//현재블럭에서 보여줄 끝 번호
	private Long lastNum;
	
	private boolean before;
	private boolean after;
	
	public Pager() {
		this.perPage = 10L;
	}
	
	public Long getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	
	


	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}
	

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

	//startRow, lastRow 계산 메서드
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	//startNum, lastNum 
	public void makeNum(Long totalCount) {
		
		
		//1. 전체 row의 갯수 구하기
		//2. 총 page의 갯수 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		
		//3. 한 블럭의 출력할 번호의 갯수
		Long perBlock = 5L;
		
		//4. 총 블럭 수
		long totalBlock = totalPage/perBlock;
		
		if(totalBlock % perBlock != 0) {
			totalBlock++;
		}
		
		//5. page 번호로 현재 블럭 번호 구하기
		Long curBlock = this.getPage()/perBlock;
		
		if(this.getPage() % perBlock != 0) {
			curBlock++;
		}
		
		//6. curblock의 시작번호와 끝번호를 계산
		this.startNum = curBlock*perBlock-(perBlock-1);
		this.lastNum = curBlock*perBlock;

		this.after = true;
		
		if(curBlock == totalBlock) {
			lastNum = totalPage;
			this.after = false;
		}
		
		if(curBlock == 1) {
			this.before = true;
		}

	}
	
	
	
}
