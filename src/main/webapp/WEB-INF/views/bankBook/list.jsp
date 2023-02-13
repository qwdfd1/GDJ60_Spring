<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../template/common_css.jsp">
<link rel="stylesheet" href="../resources/css/table.css">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<h1 class="title">BankBook List Page</h1>
	
	<div class="image">
		<img class="image" alt="" src="../resources/images/beef.jpg">
	</div>
	
	
		<table class="tbl2">
			<thead>
				<tr>
					<th>상품명</th>
					<th>이자율</th>
					<th>판매여부</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${bankBookList}" var="dto">
					<tr>
						<td><a href="detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
						<td class="tbl_td">${dto.bookRate}</td>
						<td class="tbl_td">
							<c:choose>
								<c:when test="${dto.bookSale eq 1}">판매 중</c:when>
								<c:otherwise>판매 중단</c:otherwise>
							</c:choose>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		
		<a href="./add" class="btn btn-primary">상품 등록</a>
	</div>
	
</body>
</html>