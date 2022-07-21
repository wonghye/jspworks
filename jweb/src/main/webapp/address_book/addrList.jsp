<%@page import="com.dao.AddrBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 목록</title>
<link rel="stylesheet" href="../resources/css/addrbook.css">
</head>
<jsp:useBean id="abDAO" class="com.dao.AddrBookDAO" scope="application"/>
<body>
	<div id="container">
		<h2>주소 목록</h2>
		<hr>
		<p><a href="./addrForm.jsp">주소 추가</a>
		<table id="tbl_list">
			<tr>
				<td>이름</td><td>전화번호</td><td>이메일</td><td>성별</td><td>보기</td><td>삭제</td>
			</tr>
			<%
				for(int i = 0; i<abDAO.getListAll().size(); i++){
					AddrBook addrBook = abDAO.getListAll().get(i);
			%>
			<tr>
				<td><%=addrBook.getUsername() %></td>
				<td><%=addrBook.getTel() %></td>
				<td><%=addrBook.getEmail() %></td>
				<td><%=addrBook.getGender() %></td>
			</tr>
			<% } %>
		</table>
	</div>
</body>
</html>