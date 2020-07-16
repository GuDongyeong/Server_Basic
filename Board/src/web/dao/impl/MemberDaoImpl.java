package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.JDBCTemplate;
import web.dao.face.MemberDao;
import web.dto.Member;

public class MemberDaoImpl implements MemberDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntMemberByUseridpw(Member m) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql 구문
		String sql = "";
		sql += "SELECT count(*) FROM member";
		sql += " WHERE 1=1";
		sql += " AND userid = ?";
		sql += " AND userpw = ?";
		
		// 결과값 변수
		int res = -1;
		
		try {
			// sql 수행 객체
			ps = conn.prepareStatement(sql);
			ps.setString(1, m.getUserid());
			ps.setString(2, m.getUserpw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				res = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public Member selectMemberByUserid(Member m) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql 구문
		String sql = "";
		sql += "SELECT * FROM member";
		sql += " WHERE userid = ?";
		
		// 결과값 변수
		Member user = null;
		
		try {
			// sql 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, m.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Member();
				
				user.setUserid(rs.getString("userid"));
				user.setUserpw(rs.getString("userpw"));
				user.setUsernick(rs.getString("usernick"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		
		return user;
	}

	@Override
	public void insert(Member m) {

		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql 구문
		String sql = "";
		sql += "INSERT INTO member(userid, userpw, usernick)";
		sql += " VALUES(?, ?, ?)";

		try {
			// sql 수행 객체
			ps = conn.prepareStatement(sql);
			ps.setString(1, m.getUserid());
			ps.setString(2, m.getUserpw());
			ps.setString(3, m.getUsernick());
						
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
				
	}

}
