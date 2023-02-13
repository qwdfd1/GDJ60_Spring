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
	
	
	<div class="col-6">
		<table class="table table-hover">
			
			<thead>
				<tr>
					<th>이름</th>
					<th>전화번호</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${memberDTOs}" var="dto">
				<tr>
					<td><a href="/memberPage?id=${dto.id}">${dto.name}</a></td>
					<td>${dto.phone}</td>
				</tr>	
				</c:forEach>
			</tbody>
		
		</table>
		
		<a class="btn btn-primary" href="memberJoin">회원 가입</a>
	</div>
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>