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
			
			<h3>통장 번호 : ${dto.title}</h3>
			<h3>통장 이름 : ${dto.writer}</h3>
			<h3>이자율 : ${dto.contents}</h3>
			
			
<%-- 		<c:if test="${not empty dto.bankBookImgDTO}">
			<div>
				<img href="../resources/upload/bankBook/${bankBookDTO.bankBookImgDTO.fileName}"></a>
			</div>
		</c:if> --%>
			
			<div class="row">
				<c:if test="${boardName ne 'notice'}">		
					<a href="./reply?num=${dto.num}" class="btn btn-primary col-md-2 mx-2 my-2">답글</a>
				</c:if>		 
			</div>
	</div>

	





	<div class="row">
		<div class="col-md-8">
			<a href="./delete?num=${dto.num}" class="btn btn-primary col-md-2 mx-2">상품 삭제</a>
			
			<a href="./list" class="btn btn-primary col-md-2 mx-1">목록으로</a>
			<a href="./update?num=${dto.num}" class="btn btn-primary col-md-2 mx-2">상품 수정</a>
		</div>	
	</div>
</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>