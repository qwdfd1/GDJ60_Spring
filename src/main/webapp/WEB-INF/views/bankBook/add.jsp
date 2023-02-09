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
	
		<fieldset>
			<legend>상품명</legend>
			<input type="text" name="bookName" placeholder="제품명 입력">
		</fieldset>
		
		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate">
		</fieldset>
		
		<fieldset>
			<label for="">판매 여부 : </label>
			<label for="bs1">판매</label>  
			<input id="bs1" type="radio" name="bookSale" value="1" checked="checked">
			<label for="bs2">판매 중단</label>  
			<input id="bs2" type="radio" name="bookSale" value="0"><br>
		</fieldset>
		
		<fieldset>
			<label>판매 여부 : </label>
			<select name="bookSale">
				<option value="1">판매</option>
				<option selected="selected" value="0">판매 중단</option>
	 		</select>
 		</fieldset>
 		
 		<fieldset>
 			<legend>상품 설명</legend>
			<textarea rows="3" cols="24" name="bookDetail"></textarea>
		</fieldset>
		

		
		<button class="btn btn-primary" type="submit">상품 등록</button>
	
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>	
</body>
</html>