<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/common_css.jsp"></c:import>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>


	<c:choose>
	
		<c:when test="${not empty bankBookDTO}">
			<h3>통장 번호 : ${bankBookDTO.bookNumber}</h3>
			<h3>통장 이름 : ${bankBookDTO.bookName}</h3>
			<h3>이자율 : ${bankBookDTO.bookRate}</h3>
			<h3>판매 여부 : ${bankBookDTO.bookSale}</h3>
			<h3>통장 상세내용 : ${bankBookDTO.bookDetail}</h3>
			<c:choose>
				<c:when test="${not empty bankBookDTO.bankBookImgDTO}">

					<div>
						<a href="../resources/upload/bankBook/${bankBookDTO.bankBookImgDTO.fileName}">${bankBookDTO.bankBookImgDTO.oriName}</a>
					</div>
				</c:when>
			</c:choose>
		</c:when>
	

		
		<c:otherwise>
			<h2>존재하지 않는 게시물입니다.</h2>
		</c:otherwise>
		
	</c:choose>
	
	<a href="./delete?bookNumber=${bankBookDTO.bookNumber}" class="btn btn-primary">상품 삭제</a>
	
	<a href="./list" class="btn btn-primary">목록으로</a>
	<a href="./update?bookNumber=${bankBookDTO.bookNumber }" class="btn btn-primary">상품 수정</a>

	<div class="my-5">
	  
	  <div class="row col-md-10 offset-md-1" id="commentList">

	  </div>
	  <div class="mb-3">
		<textarea class="form-control" id="replyContents" rows="3" name="contents" ></textarea>
	  </div>
	  <div class="mb-3">
		<button class="btn btn-primary" data-bookNumber="${bankBookDTO.bookNumber}" id="replyAdd">댓글 작성</button>
	  </div>

	</div>

	<!-- Update Form Modal -->
	
	<!-- Modal -->
	<div class="modal fade" id="contentsModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="form-floating">
					<textarea class="form-control" placeholder="Leave a comment here" id="contents"></textarea>
					<label for="contents">Comments</label>
				</div>
			</div>
			<div class="modal-footer">
			<button type="button" class="btn btn-secondary" id="closeModal" data-bs-dismiss="modal">Cancel</button>
			<button type="button" class="btn btn-primary" id="contentsConfirm" data-board-num="">Confirm</button>
			</div>
		</div>
		</div>
	</div>

	
	<c:import url="../template/common_js.jsp"></c:import>
	<script src="../resources/js/bankBookReply.js"></script>
</body>
</html>