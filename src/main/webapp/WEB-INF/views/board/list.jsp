<%@page import="java.util.List"%>
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

<div class="container-fluid">
	
	<div class="row my-5">
		<h1>${boardName} Page</h1>
	</div>

	<div class="row">
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th>num</th>
					<th>title</th>
					<th>writer</th>
					<th>regDate</th>
					<th>hit</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach  items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td>
						<!-- Notice에는 depth가 없어서 Exception 발생 -->
						<c:catch>
							<c:forEach begin="1" end="${dto.depth}" varStatus="s">
							--<c:if test="${s.last}">></c:if>
							</c:forEach>
						</c:catch>
						<a href="./detail?num=${dto.num}"> ${dto.title}</a></td>
						
						<c:choose>
							<c:when test="${boardName eq 'notice'}">
								<td>관리자</td>	
							</c:when>
							<c:otherwise>
								<td>${dto.writer}</td>
							</c:otherwise>
						</c:choose>
						
						<td>${dto.regDate}</td>
						<td>${dto.hit}</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
		<!-- 페이징 -->
		<div class="row">
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
  			    <li class="page-item ${pager.before ?'disabled':''}">
			      <a class="page-link" href="#" aria-label="Previous" data-board-page="1">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			  
			    <li class="page-item ${pager.before ?'disabled':''}">
			      <a class="page-link" href="#" aria-label="Previous" data-board-page="${pager.startNum-1}">
			        <span aria-hidden="true">&lsaquo;</span>
			      </a>
			    </li>
			    
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			    	<li class="page-item"><a class="page-link" href="#" data-board-page="${i}">${i}</a></li>	
			    </c:forEach>
			    
			    <li class="page-item ${pager.after eq false ? 'disabled':''}">
			      <a class="page-link" href="#"  aria-label="Next" data-board-page="${pager.lastNum+1}">
			        <span aria-hidden="true">&rsaquo;</span>
			      </a>
			    </li>
			    
			      <li class="page-item ${pager.after eq false ? 'disabled':''}">
			      <a class="page-link" href="#"  aria-label="Next" data-board-page="${pager.totalPage}">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
		</div>
		
		<!-- 검색창  -->
		<div class="row">
			
			<form class="row g-3" action="./list" method="get" id="searchForm">
				<input type="hidden" name="page" value="1" id="page">
			  <div class="col-auto">
			    <label for="kind" class="visually-hidden">Kind</label>
			    <select class="form-select" name="kind" id="kind" aria-label="Default select example">
					  <option value="title" ${pager.kind eq 'title'?'selected':''}>제목</option>
					  <option value="contents" ${pager.kind eq 'contents'?'selected':''}>글 내용</option>
					  <option value="writer" ${pager.kind eq 'writer'?'selected':''}>작성자</option>
				</select>
			  </div>
			  <div class="col-auto">
			    <label for="search" class="visually-hidden">Search</label>
			    <input type="text" class="form-control" value="${pager.search}" name="search" id="search" placeholder="검색어를 입력하세요">
			  </div>
			  <div class="col-auto">
			    <button type="submit" class="btn btn-primary mb-3">검색</button>
			  </div>
			</form>
			
			<c:if test="${not empty member}">
				<c:if test="${boardName eq 'notice' and member.roleDTO.roleName eq 'ADMIN'}">
					<div class="col-auto offset-md-3">
						<a href="./add" class="btn btn-primary"> 글 쓰기</a>
					</div>		
				</c:if>
				
				<c:if test="${boardName ne 'notice'}">
					<div class="col-auto offset-md-3">
						<a href="./add" class="btn btn-primary"> 글 쓰기</a>
					</div>					
				</c:if>
			</c:if>
		
		</div>
</div>


<c:import url="../template/common_js.jsp"></c:import>
<script src="../resources/js/paging.js"></script>
</body>
</html>