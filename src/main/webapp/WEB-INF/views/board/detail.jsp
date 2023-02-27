<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/common_css.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

<div class="container-fluid">
	<div class="row">
			<h1> ${boardName} Detail Page</h1>
			
			<h3>제목 : ${dto.title}</h3>
			<h3>작성자 : ${dto.writer}</h3>
			<h3>글 내용 : ${dto.contents}</h3>
			
			<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
				<a href="./fileDown?fileNum=${fileDTO.fileNum}">${fileDTO.oriName}</a>
			</c:forEach>
			
			
<%-- 		<c:if test="${not empty dto.bankBookImgDTO}">
			<div>
				<img href="../resources/upload/bankBook/${bankBookDTO.bankBookImgDTO.fileName}"></a>
			</div>
		</c:if> --%>
			
			<div class="row">
				<div class="col-md-8">
					<c:if test="${boardName ne 'notice'}">		
						<a href="./reply?num=${dto.num}" class="btn btn-primary col-md-2 mx-2 my-2">답글</a>
					</c:if>
				</div>		 
			</div>
	</div>



	<div class="row">
		<div class="col-md-8">
			<form action="./update" id="frm">
				<input type="hidden" name="num" value="${dto.num}">
					
				<button type="submit" class="btn btn-primary col-md-2 mx-2" id="update">상품 수정</button>

				<button type="button" class="btn btn-primary col-md-2 mx-2" id="delete">상품 삭제</button>
			</form>
		</div>
		
		<a href="./list" class="btn btn-primary col-md-2 mx-1">목록으로</a>	
		
		<!-- delete시엔 post방식 update시엔 get -->
		<div>

		</div>
	</div>
</div>
	<script type="text/javascript" src="../resources/js/boardForm.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>