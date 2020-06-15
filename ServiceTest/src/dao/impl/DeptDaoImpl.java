package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.DeptDao;
import dto.Dept;

public class DeptDaoImpl implements DeptDao {
	
	// OJDBC 드라이버 로드
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// DB 연결 정보
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERNAME = "scott";
	public static final String PASSWORD = "tiger";
	
	// OJDBC 객체
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public DeptDaoImpl() {
		
		try {
			
			// 드라이버 로드
			Class.forName(DRIVER);
			
			// DB 연결 객체 
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// Dept 테이블의 모든 데이터 조회
	@Override
	public List<Dept> selectAll() {
		
		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM dept";
		sql += " ORDER BY deptno";
		
		// 쿼리 수행 결과 List
		List<Dept> deptlist = new ArrayList<Dept>();

		try {
			
			// 쿼리 수행 객체 생성
			ps = conn.prepareStatement(sql);
			
			// 쿼리 수행
			rs = ps.executeQuery();
			
			// 결과 처리
			while(rs.next()) {
				
				Dept dept = new Dept();
				
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				deptlist.add(dept);			
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반납
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
				
				// 이거는 계속 사용할 것이기 때문에 남겨놓을 것!
//				if( conn != null )	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return deptlist;
	}


	@Override
	public void insertDept(Dept d) {
		
		// sql 작성
		String sql = "";
		sql += "INSERT INTO dept(deptno, dname, loc)";
		sql += " VALUES(?, ?, ?)";
		
		try {
			// sql 수행 객체
			ps = conn.prepareStatement(sql);
			
			// ? 채우기
			ps.setInt(1, d.getDeptno());
			ps.setString(2, d.getDname());
			ps.setString(3, d.getLoc());
			
			// sql 결과 저장
			ps.executeUpdate();
			
			// 커밋 잘못된것 !! 서비스에서 해야한다
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			// 롤백 - 잘못된 동작(SQL 수행 중 예외 발생)
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			try {
				if( ps != null )	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
