<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/common_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	<div class="container-fluid my-3">
		
		<div class="row mb-4 border-bottom border-info">
			<h1 class="col-md-7 mx-auto text-center pb-3 fs-2">${boardName} Update Page</h1><br>
		</div>
		
		<div class="row col-md-8 mx-auto border-bottom ">
			<form action="./update" method="post" enctype="multipart/form-data">
				<input type="hidden" name="num" value="${dto.num}">
				<div class="row mb-3">
				  <label for="writer" class="col-sm-2 col-form-label">작성자</label>
				  <div class="col-sm-10">
				  	<input type="text" class="form-control" name="writer" id="writer" value="${dto.writer}" readonly >
				  </div>
				</div>
				
				<div class="row mb-3">
				  <label for="title" class="col-sm-2 col-form-label">제목</label>
				  <div class="col-sm-10">
				  	<input type="text" class="form-control" name="title" id="title" value="${dto.title}" placeholder="제목 입력">
				  </div>
				</div>
				
				<div id="fileList" class="my-5">
					<button class="btn btn-primary my-3" type="button" id="button" >Add</button>
					<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
						<div class="input-group mb-3">
						  <div class="input-group-text">
						    <input class="form-check-input mt-0 deleteCheck" type="checkbox" value="${fileDTO.fileNum}" name="fileNum" aria-label="Checkbox for following text input">
						  </div>
						  <input type="text" disabled value="${fileDTO.oriName}" class="form-control" aria-label="Text input with checkbox">
						</div>
					</c:forEach>
					
					
				</div> 
				
				
				<div class="mb-5">
				  <label for="contents" class="form-label">내용</label>
				  <textarea class="form-control" name="contents" id="contents" rows="8">${dto.contents}</textarea>
				</div>
				
				
				<div class="row mt-5 mb-3 col-md-2 offset-md-10">
					<button class="btn btn-primary " type="submit">글 쓰기</button>
				</div>
			
			</form>
		</div>
	</div>


	 <script src="../resources/js/fileManager.js"></script> 
	<script>
		 setMax(5); 
		 setCount('${dto.boardFileDTOs.size()}');
		 setParam("addFiles")
		 $('#contents').summernote();
	</script>

	<c:import url="../template/common_js.jsp"></c:import>	
	
	
</body>
</html>