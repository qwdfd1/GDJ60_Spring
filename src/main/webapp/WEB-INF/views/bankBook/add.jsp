<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 등록 페이지</h1><br>
	
	<form action="./add" method="post">
		상품 이름 : <input type="text" name="bookName" placeholder="제품명 입력"><br>
		이자율 : <input type="text" name="bookRate"><br>
		판매여부 : <input type="text" name="bookSale"><br>
		상품 설명 : <textarea rows="3" cols="15" name="bookDetail"></textarea><br>
		
		<button class="btn btn-primary" type="submit">상품 등록</button>
	
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>	
</body>
</html>