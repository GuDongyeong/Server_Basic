package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 싱글톤 적용 객체 - DB 연결
// Connection 객체를 하나만 만들어서 사용할 수 있게 만든다

public class DBConn {
	
	// OJDBC 드라이버 로드
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";	
	
	//OJDBC 객체
	private static Connection conn = null; // DB 연결 객체
	
	// private 생성자 - 외부에서 객체 생성하는 걸 막는 용도
	private DBConn() {}
	
	// Connection 객체 반환 - 싱글톤 패턴 적용 메소드
	public static Connection getConnection() {
		
		if( conn == null ) { // 한번 생성된 객체를 유지하게 만듦
			try {
				//------ 드라이버 로드 ------ 
				Class.forName(DRIVER);
				
				// ------- DB 연결 ----------
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return conn; // DB 연결 객체 반환
	}
	
}