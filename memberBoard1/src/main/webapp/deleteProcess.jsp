<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberDAO" class="com.repository.MemberDAO"/>    
<% 
	String memberId = request.getParameter("memberId");

	memberDAO.deleteMember(memberId);  // 삭제처리
	
	response.sendRedirect("./memberList.jsp");  // 페이지 이동

%>