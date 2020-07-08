package service.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dbutil.DBConn;
import dto.Emp;

public interface EmpService {
	
	/**
	 * 사원 전체 목록 조회
	 * @param conn
	 * @return
	 */
	public List<Emp> list();
	
	/**
	 * 사원 정보 조회
	 * @param - 조회대상 emp
	 * @return - Emp 조회결과
	 */
	public Emp detail(Emp emp);
	
	
	/**
	 * 사원 정보를 요청객체에서 파싱한다
	 * 전달파라미터로 전달된 사원 전체 정보를 추출하는 메소드
	 * @param req - 요청정보객체
	 * @return Emp - 전달파라미터를 저장한 사원 객체
	 */
	public Emp getEmpParam(HttpServletRequest req);

	/**
	 * 사원 정보 추가
	 * @param emp - 추가할 사원 정보가 들어있는 객체
	 */
	public void join(Emp emp);

}
