<%@page import="com.onion.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Detail Page</h1>
	<%	ProductDTO productDTO = (ProductDTO)request.getAttribute("productDTO"); %>
	
	<h3><%= productDTO.getProductName() %></h3>
	<h3><%= productDTO.getProductDetail() %></h3>
	
	<hr>
	
	<h3>${requestScope.productDTO.productName}</h3>
	<h3>${requestScope.productDTO.productDetail}</h3>
	<h3>${productDTO.productJumsu + 1.2 * 10}</h3>
	
	
	
</body>
</html>