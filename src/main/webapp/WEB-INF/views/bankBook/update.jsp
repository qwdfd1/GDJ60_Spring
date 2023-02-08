<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Page</h1>
	
	<form action="update" method="post">
		상품 이름 : <input type="text" name="bookName" placeholder="제품명 입력" value="${bankBookDTO.bookName}"><br>
		이자율 : <input type="text" name="bookRate" value="${bankBookDTO.bookRate}"><br>
		판매여부 : <input type="text" name="bookSale" value="${bankBookDTO.bookSale}"><br>
		상품 설명 : <textarea rows="3" cols="15" name="bookDetail" >${bankBookDTO.bookDetail}</textarea><br>
		<input type="hidden" name="bookNumber" value="${bankBookDTO.bookNumber}">
		
		<button class="btn btn-primary" type="submit">상품 수정</button>
	</form>
</body>
</html>