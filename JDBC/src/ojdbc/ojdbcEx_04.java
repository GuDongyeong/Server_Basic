package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Emp;

public class ojdbcEx_04 {
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

		public static void main(String[] args) {
			
			// 전체 조회 결과를 저장할 리스트
			List<Emp> list = new ArrayList();
			
			try {
				// 드라이버 로드
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String job = "SALESMAN";
			// 띄어쓰기 주의!
			String sql = "";
			sql += "SELECT * FROM emp";
			sql += "	WHERE job = ?"; //preparedStatement에서는 ?로 변수 사용 가능
			sql += "	ORDER BY empno";
			
			try {
				// DB 연결
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
				// SQL 수행 객체
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, job); // ?에 job 변수값이 들어간다
				
				rs = ps.executeQuery(); 
				
				// 결과 처리
				while(rs.next()){
					
					// 새로운 Emp 생성
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
				};
				
				
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
			
		}
			
			
			
}
		




