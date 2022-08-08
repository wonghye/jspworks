package com.filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFileFilter implements Filter{
	
	PrintWriter writer = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filename = filterConfig.getInitParameter("filename");
		
		//파일이 없는 경우 처리
		if(filename == null) {
			// throw - 예외를 강제로 발생 시킴  ( (throws-예외를 미뤄놓음) 랑 다름)
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		}
		
		try {
			//파일을 생성한 후 로그 파일에 기록할 writer 객체 생성
			writer = new PrintWriter(new FileWriter(filename, true), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 클라이언트의 IP 주소
		String clientAddr = request.getRemoteAddr();
		writer.printf("클라이언트 IP 주소 : %s %n", clientAddr); // %n-줄바꿈 
		
		String contentType = response.getContentType();
		writer.printf("문서의 컨텐츠 유형 : %s %n", contentType);
		
		writer.printf("현재 일시: %s %n ", getCurrentTime());
		
		chain.doFilter(request, response);
	}

	private Object getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTimeInMillis(System.currentTimeMillis());  // 날짜 객체에 현재 시간 설정
		return formatter.format(calendar.getTime());
	}

	@Override
	public void destroy() {
		writer.close();
	}
	
	
}
