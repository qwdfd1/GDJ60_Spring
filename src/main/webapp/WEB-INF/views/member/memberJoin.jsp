<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/common_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="stylesheet"s>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Member Join Page</h1>
	
	<hr>
	
	<form action="./memberJoin" method="post" >
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="text" name="pw"><br>
		이름 : <input type="text" name="name"><br>
		연락처 : <input type="text" name="phone"><br>
		이메일 : <input type="text" name="email"><br>
		주소 : <input type="text" name="address"><br>
		
		<button class="btn btn-primary" type="submit">회원 등록</button>
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>