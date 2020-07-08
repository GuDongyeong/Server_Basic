package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Emp;

public interface EmpDao {
	
	/**
	 * EMP 테이블 전체 조회
	 * @param conn - DB 연결 객체
	 * @return - List<Emp> - 조회된 결과 리스트
	 */
	public List<Emp> selectAll(Connection conn);
	
	
	/**
	 * Emp 테이블의 지정된 사원에 대한 상세정보 조회
	 * @param conn
	 * @param emp - 지정된 사원의 empno가 들어있는 객체
 	 * @return Emp - 조회된 사원 정보
 	 * 		단, 예외가 발생하면 null값을 반환한다
	 */
	public Emp selectByEmpno(Connection conn, Emp emp);
	
	/**
	 * 사원 정보 emp 테이블에 입력하기
	 * @param conn
	 * @param emp - 사원 정보가 담긴 객체
	 */
	public void insert(Connection conn, Emp emp);

}
