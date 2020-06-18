package service.face;

import dto.Dept;

public interface DeptService {
	
	/**
	 * 지정된 부서의 정보를 조회한다
	 * @param deptno - 조회할 부서 번호
	 * @return Dept - 조회된 부서 정보
	 */
	public Dept deptInfo(int deptno);
	
}
