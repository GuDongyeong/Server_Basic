package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OjdbcEx_02 {
	// 드라이버 로드
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// DB 연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	// OJDBC 객체
	private static Connection conn = null; // DB 연결 객체
	private static Statement st = null; // SQL 수행 객체
	private static ResultSet rs = null; // SQL 조회 결과 객체

	public static void main(String[] args) {
		
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// SQL 작성
		String sql = "";
		sql += "CREATE TABLE userTest(";
		sql += "	idx NUMBER CONSTRAINT pk_user_test PRIMARY KEY, ";
		sql += "	name VARCHAR2(50) NOT NULL, ";
		sql += "	phone VARCHAR2(50) NOT NULL)";
		
		String sql2 = "";
		sql2 += "CREATE SEQUENCE seq_usertest";
		sql2 += "	INCREMENT BY 1";
		sql2 += "	START WITH 1";
		
		try {
			//DB 연결
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//SQL 수행
			st = conn.createStatement(); // Statement 객체 얻기
		
			st.execute(sql); // 테이블 생성쿼리 수행
			st.execute(sql2); // 시퀀스 생성 쿼리 수행
			
			// 생성 후 결과 처리
			rs = st.executeQuery("SELECT count(*) FROM tabs WHERE table_name = upper('userTest')");
			
			// 조회 결과에서 첫번쨰 행 찾기
			rs.next();
			
			rs.getInt("count(*)"); //컬럼명으로 가져오기
			rs.getInt(1); // 컬럼 인덱스로 가져오기
			
			if( rs.getInt(1)>0) {
				System.out.println("테이블 생성 완료");
			}else {
				System.out.println("테이블 생성 실패");
			}
			
			// 시퀀즈 존재 여부 확인
			rs = st.executeQuery("SELECT count(*) FROM user_sequences WHERE sequence_name = upper('seq_usertest')"); 

			rs.next(); // 조회 결과에서 첫 행 찾기
			
			rs.getInt(1);
			
			if( rs.getInt(1) >0) {
				System.out.println("시퀀스 생성 완료");
			}else {
				System.out.println("시퀀스 생성 실패");
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)	rs.close();
				if(st != null )	st.close();
				if(conn != null ) conn.close();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	
}
