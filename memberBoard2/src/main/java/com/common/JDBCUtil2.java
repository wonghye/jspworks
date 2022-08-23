package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil2 {

	private static String dirverClass = "oracle.jdbc.OracleDriver";
	private static String url ="jdbc:oracle:thin:@localhost:1521:xe";
	
	private static String username = "system";
	private static String passwd = "12345";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	//db연결 메서드
	public static Connection getConnection() {
		try {
			Class.forName(dirverClass);
			return DriverManager.getConnection(url, username, passwd);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				pstmt = null;
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				conn = null;
			}
			}
		}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				pstmt = null;
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}

}
