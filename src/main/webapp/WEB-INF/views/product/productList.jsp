<%@page import="com.onion.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>
	<h1 class="title">Product List Page</h1>
	c
	<% 
		List<ProductDTO> productDTOs = (List<ProductDTO>)request.getAttribute("productDTOs"); 
		
		for(ProductDTO productDTO : productDTOs) { 
	%>
	
		<h3><%=productDTO.getProductName() %></h3>
		<h3><%=productDTO.getProductJumsu()%></h3>
	<% } %>
	
	<hr>
	
	<table class="tbl2">
		<thead>
			<tr>
				<th>상품명</th>
				<th>평점</th>
			</tr>
		</thead>
		
		<tbody>
	
			<c:forEach items="${productDTOs}" var="dto">    <!--dto PAGE 영역에 담김 -->
			<tr>
				<td><a href="detail?productNum=${dto.productNum}">${pageScope.dto.productName }</a></td>
				<td>${dto.productJumsu}</td>
			</tr>
			</c:forEach>
	
	
		</tbody>
	</table>	
	
		<a class="btn btn-primary" href="productAdd">상품 등록</a>
	
	
	 
	</body>
</html>
