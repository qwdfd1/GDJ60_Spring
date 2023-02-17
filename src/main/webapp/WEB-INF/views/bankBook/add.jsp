<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/common_css.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid my-3">
		
		<div class="row mb-4 border-bottom border-info">
			<h1 class="col-md-7 mx-auto text-center pb-3 fs-2">상품 등록 페이지</h1><br>
		</div>
		
		<div class="row col-md-8 mx-auto border-bottom ">
			<form action="./add" method="post">
			
				<div class="row mb-3">
				  <label for="exampleFormControlInput1" class="col-sm-1 col-form-label">상품명</label>
				  <div class="col-sm-10">
				  	<input type="text" class="form-control" name="bookName" id="exampleFormControlInput1" placeholder="상품명 입력">
				  </div>
				</div>
				
				<div class="row mb-3">
				  <label for="exampleFormControlInput2" class="col-sm-1 col-form-label">이자율 </label>
				  <div class="col-sm-10">
				  	<input type="text" class="form-control" name="bookRate" id="exampleFormControlInput2" placeholder="ex) 1.2 ...">
				  </div>
				</div>
				
				<div class="row mb-3">
				  <label for="exampleFormControlInput3" class="col-sm-1 col-form-label">Image </label>
				  <div class="col-sm-10">
				  	<input type="file" class="form-control" name="pic" id="exampleFormControlInput3" placeholder="ex) 1.2 ...">
				  </div>
				</div>
				
				
				<fieldset class="row mb-3">
				    <legend class="col-form-label col-sm-1 pt-0">판매 여부</legend>
				    <div class="col-sm-10">
				      <div class="form-check">
				        <input class="form-check-input" type="radio" name="bookSale" id="bookSale1" value="1" checked>
				        <label class="form-check-label" for="bookSale1">
				          판매 중
				        </label>
				      </div>
				      <div class="form-check">
				        <input class="form-check-input" type="radio" name="bookSale" id="bookSale2" value="0">
				        <label class="form-check-label" for="boolSale2">
				          판매 중단
				        </label>
				      </div>
				    </div>
				  </fieldset>
				

				<div class="mb-5">
				  <label for="exampleFormControlTextarea1" class="form-label">상세 설명</label>
				  <textarea class="form-control" name="bookDetail" id="exampleFormControlTextarea1" rows="3"></textarea>
				</div>
				
				
				<div class="row mt-5 mb-3 col-md-1 offset-md-11">
					<button class="btn btn-primary " type="submit">상품 등록</button>
				</div>
			
			</form>
		</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>	
</body>
</html>