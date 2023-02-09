<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link rel="stylesheet" href="./resources/css/main.css">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<div class="menu">
	<a href="./product/list?" >Product List</a>
	<a href="./member/memberList">Member List</a>
	<a href="./bankBook/list">BankBook List</a>
</div>

<img alt="곱창" src="./resources/images/gobchang.jpg">
<img alt="소고기" src="./resources/images/beef.jpg">

<iframe width="560" height="315" src="https://www.youtube.com/embed/A8Qyf59LRIA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
