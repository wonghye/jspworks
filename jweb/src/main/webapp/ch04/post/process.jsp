<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//한글 인코딩 처리
	request.setCharacterEncoding("utf-8");

	String[] fruit = request.getParameterValues("fruit");
%>

<p>선택한 과일
<p><%
		for(int i = 0; i<fruit.length; i++){
			out.println(fruit[i]);
		}
	
	%>
</p>	