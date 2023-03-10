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
		

		
		
			<div class="row col-md-8 mx-auto pt-3 border-bottom mt-5">
				<div class="row mb-4 border-bottom border-info">
					<h1 class="col-md-7 mx-auto text-center pb-3 fs-2">Login Page</h1><br>
				</div>	
				<form action="./memberLogin" method="post">
				
					<div class="row mb-3 justify-content-center mt-5">
					  <label for="memberId" class="col-sm-1 col-form-label">ID</label>
					  <div class="col-sm-5">
					  	<input type="text" class="form-control" value="${cookie.rememberId.value}" name="id" id="memberId" placeholder="아이디 입력">
					  </div>
					</div>
					
					<div class="row mb-3 justify-content-center mt-5">
					  <label for="memberPw" class="col-sm-1 col-form-label">Password</label>
					  <div class="col-sm-5">
					  	<input type="password" class="form-control" name="pw" id="memberPw">
					  </div>
					</div>
					
					<div class="row mb-3 justify-content-center mt-5 form-check">
						<label for="" class="col-sm-1 col-form-label">Remember</label>
			            <input type="checkbox" name="remember" value="remember" class="form-check-input">
       				</div>
	
					
					
					<div class="row mt-5 mb-3 col-md-1 offset-md-11">
						<button class="btn btn-primary " type="submit">Login</button>
					</div>
				
				</form>
			</div>
		</div>
	
	<c:import url="../template/common_js.jsp"></c:import>	
</body>
</html>