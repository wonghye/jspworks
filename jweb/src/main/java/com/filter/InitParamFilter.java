package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitParamFilter implements Filter {
	
	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("Filter02 초기화..");
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");  // 문서 유형
		
		PrintWriter writer = response.getWriter();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// param1,param2  web.xml 등록 예정
		String param1 = filterConfig.getInitParameter("param1");  
		String param2 = filterConfig.getInitParameter("param2");  
		
		String message = "";
		if(id.equals(param1) && passwd.equals(param2)) {
			message = "로그인 성공했습니다!";
		}else {
			message = "로그인 실패했습니다.";
		}
		
		writer.println(message);  // 메세지 브라우저에 출력함
		
		chain.doFilter(request, response);  // 인증 필터 실행
	}	
	
	
	@Override
	public void destroy() {
		System.out.println("Filter01 해제..");
	}
}
