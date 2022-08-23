<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~ </title>
<link rel="stylesheet" href="./resources/css/common.css">
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<div class="title">
			<h1>Board</h1>
		</div>
		<div>
			<%-- <p style="margin-right: 30%">게시글 총 수 : <c:out value="${total }" /> --%>
			<table class="tbl_list">
				<thead>
					<tr>
						<th>번호</th><th>제목</th><th>글쓴이</th><th>작성일</th><th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td><c:out value="${board.bnum}" /></td>
						<td><a href="./boardView.do?bnum=<c:out value="${board.bnum}" /> "> <c:out value="${board.title}" /></a></td>
						<td><c:out value="${board.memberId}" /></td>
						<td><fmt:formatDate value="${board.regDate}" 
						     pattern="yyyy-MM-dd hh:mm:ss"/></td>
						<td><c:out value="${board.hit }" /></td>     
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div style="margin-top: 10px;">
			<!-- 이전 버튼 -->
			<c:if test="${startPage > 1 }">
				<a href="/boardList.do?pageNum=<c:out value='${startPage-1 }' />">이전 </a> 
			</c:if>	
			<c:if test="${startPage <= 1 }">
				<a href="/boardList.do?pageNum=<c:out value='${startPage }' />">이전 </a> 
			</c:if>	
			<c:forEach var="i" begin="1" end="${endPage }">
				<!--  현재 페이지와 페이지 번호가 같으면 굵게 표시  -->
				<c:if test="${currentPage eq i }">
					<a href="/boardList.do?pageNum=<c:out value='${i }' />"><b><c:out value="${i }" /></b> </a> 
				</c:if> 
				<c:if test="${currentPage ne i }"> <!-- ne = not eq -->
				<a href="/boardList.do?pageNum=<c:out value='${i }' />"><c:out value="${i }" /></a> 
				</c:if>
			</c:forEach>
				<!-- 다음 버튼  -->
				<c:if test="${endPage > startPage }" >
					<a href="/boardList.do?pageNum=<c:out value='${startPage +1 }' />">다음 </a> 
				</c:if>
				<c:if test="${endPage <= startPage }" >
					<a href="/boardList.do?pageNum=<c:out value='${startPage }' />">다음 </a> 
				</c:if>
			</div>
			<div class="btnWrite">
				<a href="./writeForm.do"><button type="button">글쓰기</button></a>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>