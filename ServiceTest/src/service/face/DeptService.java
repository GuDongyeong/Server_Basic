package service.face;

import java.util.List;

import dto.Dept;

public interface DeptService {
	
	// Dept 테이블의 모든 데이터 조회
	// 부서 정보 전체 조회
	// @return List<Dept> - 조회된 부서 정보 리스트
	public List<Dept> deptList();

	
	/**
	 * 신규 부서 정보 입력
	 * @param dept - 새롭게 입력될 부서 정보
	 */
	public void addDept(Dept dept);
}
