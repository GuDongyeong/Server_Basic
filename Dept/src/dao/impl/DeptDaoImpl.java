package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.face.DeptDao;
import dto.Dept;

public class DeptDaoImpl implements DeptDao{
	
	public PreparedStatement ps = null; // SQL 수행 객체
	public ResultSet rs = null; // 조회결과객체
	
	@Override
	public Dept selectOne(Connection conn, int deptno) {
		
		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM dept";
		sql += " WHERE deptno = ?";
		
		// 쿼리 수행 결과 객체
		Dept dept = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			rs = ps.executeQuery();
			while( rs.next()) {
				dept = new Dept();
				
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
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
		
		return dept;
	}

}
