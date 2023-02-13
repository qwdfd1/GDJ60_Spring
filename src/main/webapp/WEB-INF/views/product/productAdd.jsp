<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="col-6">
		<form action="./productAdd" method="post">
			상품명 : <input type="text" name="productName"><br>
			
			상품정보 : <textarea name="productDetail" id="" cols="15" rows="4"></textarea>
			
			<button type="submit"> 등록</button>
		</form>	
	</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>