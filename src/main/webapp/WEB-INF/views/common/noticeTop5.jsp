<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row col-md-1 offset-md-2">
		<table class="table table-hover table-striped">
			
			<tbody>
				<c:forEach  items="${list}" var="dto" varStatus="i">
					<tr>
						<td><a href="./detail?num=${dto.num}"> ${dto.title}</a></td>
						<c:if test="${i.first}">
							${dto.contents}
						</c:if>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

