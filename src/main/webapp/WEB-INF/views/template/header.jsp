<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
  	<div class="container-fluid">
  		<a class="navbar-brand" href="/"><img src="/resources/images/logo.png" alt=""></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/list">제품</a></li>
				<li class="nav-item"><a class="nav-link" href="/bankBook/list">저축상품</a></li>
				<li class="nav-item"><a class="nav-link" href="#">기타메뉴</a></li>
			</ul>
			
			<ul class="navbar-nav">
				<c:if test="${empty memberDTO}">
					<li class="nav-item"><a class="nav-link" style="font-size: 12px;" href="/member/memberLogin">Login</a></li>
					<li class="nav-item"><a class="nav-link" style="font-size: 12px;" href="/member/memberJoin">Join</a></li>
				</c:if>
				<c:if test="${not empty memberDTO}">
					<li class="nav-item"><a class="nav-link" style="font-size: 12px;" href="/member/memberPage">MyPage</a></li>
					<li class="nav-item"><a class="nav-link" style="font-size: 12px;" href="/member/memberLogout">Logout</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link disabled" style="font-size: 12px;">|</a></li>
				<li class="nav-item"><a class="nav-link" style="font-size: 12px;" href="#">KO</a></li>
				<li class="nav-item"><a class="nav-link" style="font-size: 12px;" href="#">EN</a></li>
				<li class="nav-item"><a class="nav-link" style="font-size: 12px;" href="#">JP</a></li>
				<li class="nav-item"><a class="nav-link" style="font-size: 12px;" href="#">CN</a></li>
			</ul>
		</div>
	</div>
</nav>
