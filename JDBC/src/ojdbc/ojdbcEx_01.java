package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC 사용방법
// 1. JDBC 드라이버 로드
// 2. DB 접속(연결,  Connect)
// 3. SQL 쿼리 수행
// 4. 조회된 결과 처리
// 5. 연결 종료



public class ojdbcEx_01 {
	public static void main(String[] args) {
		
	
	try {
		// 1. JDBC 드라이버 로드
		
		// 클래스가 가지고 있는 고유한 이름을 가지고 호출
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//--- OJDBC 사용에 필요한 변수들
		Connection conn = null; // DB 연결 객체(접속 객체)
		Statement st = null; // SQP 구문 저장 및 수행 객체
		ResultSet rs = null; // 조회 결과 반환 객체
	
		//-------------------------
		
		// 2. DB 접속(연결,  Connection)
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				 
		// 3. SQL 쿼리 수행
		
		//3.1 쿼리 수행객체 생성
		st = conn.createStatement();
		
		//3.2 SQL 수행 및 결과 저장(ResultSet)
		rs = st.executeQuery("SELECT * FROM emp ORDER BY empno");
		
		// 4. 조회된 결과 처리
		
		//조회된 행이 존재하는 만큼 반복코드
		while( rs.next()) {
			
			//rs.next를 한번 수행할 떄마다 조회된 결과에서 순차적으로 한 행씩 참조
			System.out.print(rs.getString("empno"));	
			System.out.println();
		}
		
		
		// 5. 연결 종료
		
	
	
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
		
		
	}
}
