package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.common.JDBCUtil;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//회원 추가
	public void addMember(Member member) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO t_member(memberid, passwd, name, gender) " 
			+ "VALUES (? , ?, ?, ? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());  // 화면에 입력된 값을 DB 저장
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.executeUpdate();  // 쿼리문 실행 함수
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	//회원 목록
	public ArrayList<Member> getListAll(){
		ArrayList<Member> memberList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();  //db연결
			//칼럼에서 가입일이 생략된 경우이므로 열을 표기해야함.
			String sql = "SELECT * FROM t_member ORDER BY joindate DESC";
			pstmt = conn.prepareStatement(sql);   //sql처리 객체 생성
			rs = pstmt.executeQuery();  // select 실행문
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("memberid"));  // db에서 가져와서 member에 세팅
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setJoinDate(rs.getDate("joindate"));
				
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return memberList;
	}
	
	//로그인 체크
	public Boolean checkLogin(String memberId, String password) {
		
		try {
			conn = JDBCUtil.getConnection();  //db연결
			String sql = "SELECT * FROM t_member WHERE memberid=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {  // 아이디,비밀번호 일치 하면
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return false;
	}
	
	//회원 삭제
	public void deleteMember(String memberId) {
		
		try {
			conn = JDBCUtil.getConnection();  //db연결
			String sql = "DELETE FROM t_member WHERE memberid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
}
