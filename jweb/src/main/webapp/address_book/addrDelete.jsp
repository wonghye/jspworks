<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="abDAO" class="com.dao.AddrBookDAO" scope="application" />
<%
	String uname = request.getParameter("username");
	
	//세션이 없는 경우 주소록 등록 페이지로 가기
	if(session.getAttribute("userName") != null){
		abDAO.delete(uname); //dao의 delete() 호출
		response.sendRedirect("addrList.jsp"); // 목록 페이지로 이동
	}else{
		response.sendRedirect("./addrForm.jsp"); // 등록 폼 이동
	}
%>