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


	<c:choose>
	
		<c:when test="${not empty bankBookDTO}">
			<h3>통장 번호 : ${bankBookDTO.bookNumber}</h3>
			<h3>통장 이름 : ${bankBookDTO.bookName}</h3>
			<h3>이자율 : ${bankBookDTO.bookRate}</h3>
			<h3>판매 여부 : ${bankBookDTO.bookSale}</h3>
			<h3>통장 상세내용 : ${bankBookDTO.bookDetail}</h3>
		</c:when>
		<c:if test="${not empty bankBookDTO.bankBookImgDTO}">
			<div>
				<img href="../resources/upload/bankBook/${bankBookDTO.bankBookImgDTO.fileName}"></a>
			</div>
		</c:if>

		
		<c:otherwise>
			<h2>존재하지 않는 게시물입니다.</h2>
		</c:otherwise>
		
	</c:choose>
	
	<a href="./delete?bookNumber=${bankBookDTO.bookNumber}" class="btn btn-primary">상품 삭제</a>
	
	<a href="./list" class="btn btn-primary">목록으로</a>
	<a href="./update?bookNumber=${bankBookDTO.bookNumber }" class="btn btn-primary">상품 수정</a>
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>