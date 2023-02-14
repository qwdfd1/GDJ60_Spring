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
			<h1>Member MyPage</h1>
		</div>
		
		
		<div class="row col-6">
				<h1>이름 : ${memberDTO.name}</h1>
				<h1>연락처 : ${memberDTO.phone}</h1>
				<h1>Email : ${memberDTO.email}</h1>
				<h1>주소 : ${memberDTO.address}</h1>
				<a class="btn btn-info" href="./memberUpdate">회원정보 수정</a>
		</div>
	</div>
	
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>