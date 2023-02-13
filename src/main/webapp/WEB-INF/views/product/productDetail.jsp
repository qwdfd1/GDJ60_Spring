<%@page import="com.onion.s1.product.ProductDTO"%>
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
	<%	ProductDTO productDTO = (ProductDTO)request.getAttribute("productDTO"); %>
	
	<h3><%= productDTO.getProductName() %></h3>
	<h3><%= productDTO.getProductDetail() %></h3>
	
	<hr>
	
	<h3>${requestScope.productDTO.productName}</h3>
	<h3>${requestScope.productDTO.productDetail}</h3>
	<h3>${productDTO.productJumsu + 1.2 * 10}</h3>
	
	
		<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>