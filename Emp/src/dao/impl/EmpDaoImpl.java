package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {

	// OJDBC 관련 객체
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;	
	
	@Override
	public List<Emp> selectAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " ORDER BY empno";
		
		List<Emp> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			// 결과 처리
			while(rs.next()) {
				Emp emp = new Emp(); // 새로운 Emp 객체 생성
				
				// ResultSet에서 데이터를 꺼내 Emp 객체에 삽입
				
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
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
		return list;
	}

	@Override
	public Emp selectByEmpno(Connection conn, Emp emp) {
		
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE empno = ?";
		
		// 결과 저장할 DTO, 밑에서 에러가 발생한 경우 결과값에 null이 담겨있을 수 있도록
		Emp result = null;
		
		try {
			ps = conn.prepareStatement(sql);// SQL 수행 객체 생성
			ps.setInt(1, emp.getEmpno()); // 조회될 사원번호 적용
			rs = ps.executeQuery(); // SQL 수행 및 결과 반환
			
			while(rs.next()) {
			
				result = new Emp();
				
				result.setEmpno(rs.getInt("empno"));
				result.setEname(rs.getString("ename"));
				result.setJob(rs.getString("job"));
				result.setMgr(rs.getInt("mgr"));
				result.setHiredate(rs.getDate("hiredate"));
				result.setSal(rs.getDouble("sal"));
				result.setComm(rs.getDouble("comm"));
				result.setDeptno(rs.getInt("deptno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public void insert(Connection conn, Emp emp) {
		
		String sql = "";
		sql += "INSERT INTO emp";
		sql += " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			// SQL  쿼리에 ? 채우기
			
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getMgr());

			// 자바는 Date 클래스에 문제가 많다... 보통 String으로 입력받음
			
			// PreparedStatement 의 setDate() 메소드는 java.sql.Date 를 입력받는다
			
			// java.util.Date  타입의 정보를 java.sql.Date 로 변경해야함
			//	-> java.sql.Date(long millis) 생성자를 이용한다
			java.sql.Date hiredate = new java.sql.Date(emp.getHiredate().getTime());
			ps.setDate(5, hiredate);
			
			ps.setDouble(6, emp.getSal());
			ps.setDouble(7, emp.getComm());
			ps.setInt(8, emp.getDeptno());
			
			ps.executeUpdate(); // SQL 수행
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
