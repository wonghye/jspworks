package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenFilter implements Filter {
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter01 초기화..");
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.한글 인코딩 요청 - 필터로 등록 
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("name");
		String message = "";
		
		//2.입력값이 없을 경우 필터 처리 (방법 2가지 1- string 메세지없이 바로 ,2- string 메세지 사용하여)
		if(name == null || name.equals("")) {
			//writer.println("입력된 값은 null입니다.");
			message = "입력된 값은 null입니다.";
			writer.println(message);
			return;  // 프로그램 정상 종료
		}
		
		chain.doFilter(request, response);  // 실행함수 - 안하면 안됨
	}
	
	@Override
	public void destroy() {
		System.out.println("Filter01 해제..");
	}

}
