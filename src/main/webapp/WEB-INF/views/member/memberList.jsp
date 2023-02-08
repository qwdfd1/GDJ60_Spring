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
	<h1>Member List</h1>
	
	<hr>
	
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
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>