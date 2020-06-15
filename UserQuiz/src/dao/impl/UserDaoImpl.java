package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.UserDao;
import dto.User;

public class UserDaoImpl implements UserDao{
	
	// OJDBC 드라이버 로드
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	
	// DB 연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	// OJDBC 객체
	private static Connection conn = null; // DB 연결 객체
	private static PreparedStatement ps = null; // SQL 수행 객체
	private static ResultSet rs = null; // 조회결과객체	
	
	
	public UserDaoImpl() {
		
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
			
			// DB 연결
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<User> selectAll() {
		
		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM userTest ORDER BY idx";
		
		// 결과 저장될 List
		List<User> list = new ArrayList<User>();
		
		try {
			
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql);
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			while( rs.next() ) {// 모든 데이터(행)을 반복
				
				// 데이터 저장할 User 객체 생성
				User user = new User();
				
				// Resultset에서 User 객체에 데이터 담기
				user.setIdx(rs.getInt("idx"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				
				list.add(user);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
				if( conn != null )	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public void insertUser(User u) {
		
		// 저장할 id, name 변수
		String userid = u.getUserid();
		String name = u.getName();
		
		// 실행할 sql
		String sql = "";
		sql += "INSERT INTO userTest";
		sql += "	VALUES(userTest_SQ.NEXTVAL, ?, ?)";
		
		try {
			
			// sql 수행 객체 생성
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, name);
			
			// sql 수행 및 결과 저장
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
				if( conn != null )	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public User selectByIdx(int idx) {

		// 결과 저장될 user 객체
		User user = new User();
		
		String sql = "";
		sql += "SELECT * FROM userTest";
		sql += "	WHERE idx = ?";
		
		try {
			
			// sql 수행 객체 생성
			ps = conn.prepareStatement(sql);
			
			// sql 수행 및 결과 저장
			ps.setInt(1, idx);
			
			rs = ps.executeQuery();
			
			// 조회 결과 처리
			rs.next();
			
			user.setIdx(rs.getInt("idx"));
			user.setUserid(rs.getString("userid"));
			user.setName(rs.getString("name"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
				if( conn != null )	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}

	@Override
	public void deleteByIdx(int idx) {
		
		String sql = "";
		sql += "DELETE FROM userTest";
		sql += "	WHERE idx = ?";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idx);
			
			rs = ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
				if( conn != null )	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
	}

}
