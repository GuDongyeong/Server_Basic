package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {

	// 드라이버 로드
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// DB 연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	// OJDBC 객체
	private static Connection conn = null; // DB 연결 객체
	private static PreparedStatement ps = null; // SQL 수행 객체
	private static ResultSet rs = null; // SQL 조회 결과 객체
	
	public EmpDaoImpl() { // 생성자 안에 모든 메소드가 동일하게 필요한 드라이버로드, db 연결 넣어놓기
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
	public List<Emp> selectAll() {
		
		// SQL 작성s
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += "	ORDER BY empno";
		
		// 결과 저장될 리스트
		List<Emp> list = new ArrayList();
		
		try {
			// sql 수행 객체 생성
			ps = conn.prepareStatement(sql);
			
			// sql 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//결과 처리
			while(rs.next()) {
				// 새로운 빈 Emp 객체 생성
				Emp emp = new Emp();
				
				// ResultSet에서 Emp 객체에 데이터 담기
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				// DTO를 list에 담기
				list.add(emp);
				
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
	public List<Emp> selectDeptno20() {
		
		List<Emp> list = new ArrayList();
		
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += "	WHERE deptno = 20";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				Emp emp = new Emp();
				
				// ResultSet에서 Emp 객체에 데이터 담기
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				list.add(emp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
				if( conn != null )	conn.close();
			} catch (SQLException e) {
			}
		}
		
		return list;
	}

	@Override
	public List<Emp> selectByDeptno(int deptno) {
		
		List<Emp> list = new ArrayList<>();
		
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += "	WHERE deptno = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				Emp emp = new Emp();
				
				// ResultSet에서 Emp 객체에 데이터 담기
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				list.add(emp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
				if( conn != null )	conn.close();
			} catch (SQLException e) {
			}
		}
		
		return list;
	}

	@Override
	public void insert(Emp emp) {
		
		String sql = "";
		sql += "INSERT INTO emp";
		sql += " VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getMgr());
			java.sql.Date hiredate = new java.sql.Date(emp.getHiredate().getTime());
			ps.setDate(5, hiredate);
			ps.setDouble(6, emp.getSal());
			ps.setDouble(7, emp.getComm());
			ps.setInt(8, emp.getDeptno());
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
				if( conn != null )	conn.close();
			} catch (SQLException e) {
			}
		}
		
	}
	
}
