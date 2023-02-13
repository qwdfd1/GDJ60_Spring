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
	
	
	<form action="update" method="post">
		
		<fieldset>
			<legend>상품 이름</legend>
			<input type="text" name="bookName" placeholder="제품명 입력" value="${bankBookDTO.bookName}"><br>
		</fieldset>
		
		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate" value="${bankBookDTO.bookRate}"><br>
		</fieldset>
		
		
		<fieldset>
			<label for="bs1">판매</label>
			<input id="bs1" type="radio" ${bankBookDTO.bookSale eq '1' ? 'checked' :'' } name="bookSale" value="${bankBookDTO.bookSale}">
			
			<label for="bs2">판매 중단</label>
			<input id="bs2" type="radio" ${bankBookDTO.bookSale eq '0' ? 'checked' :'' } name="bookSale" value="${bankBookDTO.bookSale}">
		</fieldset>
		
		<fieldset>
			<legend>판매 여부</legend>
			<select name="bookSale">
				<option ${bankBookDTO.bookSale eq '1' ? 'selected' :'' } value="1">판매</option>
				<option ${bankBookDTO.bookSale eq '0' ? 'selected' :'' } value="0">판매 중단</option>
			</select>
		</fieldset>
		
		<fieldset>
			<legend>상품 설명</legend>
			<textarea rows="3" cols="15" name="bookDetail" >${bankBookDTO.bookDetail}</textarea><br>
		</fieldset>
		<input type="hidden" name="bookNumber" value="${bankBookDTO.bookNumber}">
		
		<button class="btn btn-primary" type="submit">상품 수정</button>
	</form>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>