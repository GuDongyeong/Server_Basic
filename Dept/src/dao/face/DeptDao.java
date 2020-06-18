package dao.face;

import java.sql.Connection;

import dto.Dept;

public interface DeptDao {
	
	/**
	 * 지정된 부서번호의 부서정보 조회
	 * 
	 * @param Conn - DB 연결 객체
	 * @param deptno - 조회할 부서 번호
	 * @return Dept - 조회된 부서 정보
	 */
	public Dept selectOne(Connection conn, int deptno);

}
