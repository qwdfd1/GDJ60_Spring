<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/common_css.jsp"></c:import>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<title>Insert title here</title>
<style>
    .blueResult {
      color: blue;
    }

    .redResult {
      color: red;
    }
</style>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
<section class="vh-100" style="background-color: #5bc0de;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Member Join</p>

                <form class="mx-1 mx-md-4" action="./memberJoin" method="post" id="frm">
                
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="formName">Your Name</label>
                      <input type="text" id="formName" name="name" class="form-control" />
                      <label class="form-label" for="formName" id="nameMsg"></label>
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0" >
                      <label class="form-label" for="formId">ID</label>
                      <input type="text" id="formId" name="id" class="form-control" />
                      <label class="form-label" for="formId" id="idMsg"></label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="formPw">Password</label>
                      <input type="password" id="formPw" name="pw" class="form-control" />
                      <label class="form-label" for="formPw" id="pwMsg"></label>
                      
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="formPwCk">Check Password</label>
                      <input type="password" id="formPwCk" name="pwCheck" class="form-control" />
                      <label class="form-label" for="formPwCk" id="pwCkMsg"></label>
                      
                    </div>
                  </div>

                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fa fa-phone fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="formPhone">Your Phone</label>
                      <input type="text" id="formPhone" name="phone" class="form-control" />
                      <label class="form-label" for="formPhone" id="phoneMsg"></label>
                      
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="formEmail">Your Email</label>
                      <input type="email" id="formEmail" name="email" class="form-control" />
                      <label class="form-label" for="formEmail" id="emailMsg"></label>
                      
                    </div>
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fa fa-home fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="formAddress">Your Address</label>
                      <input type="text" id="formAddress" name="address" class="form-control" />
                      <label class="form-label" for="formAddress" id="addressMsg"></label>
                      
                    </div>
                  </div>
                  

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="button" class="btn btn-primary btn-lg" id="btn">Register</button>
                  </div>

                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
	
  <script src="../resources/js/memberJoin.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>	
</body>
</html>