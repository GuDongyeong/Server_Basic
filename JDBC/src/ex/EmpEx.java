package ex;

import java.util.Date;
import java.util.List;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;

public class EmpEx {

	// EmpDao 객체 멤버필드로 생성
	private static EmpDao empDao = new EmpDaoImpl();
	
	public static void main(String[] args) {
		
		List<Emp> list;
		
		// DAO를 통한 emp 테이블전체 조회
//		list = empDao.selectAll();
//		
//		for( Emp emp: list) {
//			System.out.println(emp);
//		}
		
		// 20번 부서의 사원들 조회
//		list = empDao.selectDeptno20();
//		
//		for( Emp emp: list) {
//			System.out.println(emp);
//		}
		
		// 지정된 부서 사원들 조회
//		list = empDao.selectByDeptno(30);
//		
//		for( Emp emp: list) {
//			System.out.println(emp);
//		}
		
		// 새로운 사원정보 삽입
		Emp emp = new Emp();
		emp.setEmpno(1);
		emp.setEname("test");
		emp.setJob("salseman");
		emp.setMgr(1000);
		emp.setHiredate(new Date());
		emp.setSal(200);
		emp.setComm(100);
		emp.setDeptno(10);
//		System.out.println(emp);
		
		
		empDao.insert(emp);
	}

}
