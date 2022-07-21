<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	
	//쿠키 삭제
	for(int i = 0; i<cookies.length; i++){
		cookies[i].setMaxAge(0); // 쿠키 유효기간 0으로 설정
		
		//클라이언트 컴에 쿠키 발행
		response.addCookie(cookies[i]);
	}
	
	
	//쿠키02 페이지로 강제이동
	response.sendRedirect("cookie02.jsp");



%>