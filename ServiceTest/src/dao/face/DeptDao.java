package dao.face;

import java.util.List;

import dto.Dept;

public interface DeptDao {
	
//	Dept 테이블 전체 조회
	// @return List<Dept>  - 조회된 전체 행
	public List<Dept> selectAll();
	
	/**
	 * Dept 테이블에 전달인자 dept를 삽입한다
	 * @param dept - 삽입할 객체
	 */
	public void insertDept(Dept dept);
	

}
