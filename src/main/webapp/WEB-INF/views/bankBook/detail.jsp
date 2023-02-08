<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail Page</h1>
	<hr>
	<c:choose>
	
		<c:when test="${not empty bankBookDTO}">
			<h3>통장 번호 : ${bankBookDTO.bookNumber}</h3>
			<h3>통장 이름 : ${bankBookDTO.bookName}</h3>
			<h3>이자율 : ${bankBookDTO.bookRate}</h3>
			<h3>판매 여부 : ${bankBookDTO.bookSale}</h3>
			<h3>통장 상세내용 : ${bankBookDTO.bookDetail}</h3>
		</c:when>
		
		<c:otherwise>
			<h2>존재하지 않는 게시물입니다.</h2>
		</c:otherwise>
		
	</c:choose>
	
	<a href="./delete?bookNumber=${bankBookDTO.bookNumber}" class="btn btn-primary">상품 삭제</a>
	
	<a href="./list">목록으로</a>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>