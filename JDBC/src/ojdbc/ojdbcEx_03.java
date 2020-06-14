package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ojdbcEx_03 {
	// 드라이버 로드
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// DB 연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	// OJDBC 객체
	private static Connection conn = null; // DB 연결 객체
	
	private static Statement st = null; // SQL 수행 객체
	private static PreparedStatement ps = null; // SQL 수행 객체
	
	private static ResultSet rs = null; // SQL 조회 결과 객체

	public static void main(String[] args) {
		
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String job = "SALESMAN";
		
		// SQL 작성
//		String sql = "";
//		sql += "SELECT * FROM emp";
//		sql += "	WHERE job = '" + job + "'"; // 변수로 입력받으려면 sql 문에 입력할 때 ''(작은따옴표) 신경써야함
//		sql += "	ORDER BY empno";
		
		// 띄어쓰기 주의!
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += "	WHERE job = ?"; //preparedStatement에서는 ?로 변수 사용 가능
		sql += "	ORDER BY empno";
		
		try {
			// DB 연결
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// SQL 수행 객체
			// Statement 객체는 생성(createStatement) 될떄 매개변수 없음
			// execute할 때 쿼리를 매개변수로 전달
			
//			st = conn.createStatement();
//			rs = st.executeQuery(sql);
			
			// PreparedStatement 객체는 생성(prepareStatement)될 때 쿼리를 매개변수로 사용함
			// execute 전에 ? 값을 채워줘야 한다
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, job); // ?에 job 변수값이 들어간다
			
			rs = ps.executeQuery(); 
			
			// 조회 결과 처리
			// 조회된 행이 존재하는 만큼 반복하는 코드
			while(rs.next()) {
				System.out.print(rs.getString("empno") + ",");
				System.out.print(rs.getString(2) + ","); 
				System.out.print(rs.getString(3) + ","); 
				System.out.print(rs.getString(4) + ","); 
				System.out.print(rs.getString(5) + ","); 
				System.out.print(rs.getString(6) + ","); 
				System.out.print(rs.getString(7) + ","); 
				System.out.print(rs.getString(8)); 
				System.out.println();
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null )	rs.close();
				if( ps != null )	ps.close();
				if( conn != null )	conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
}
