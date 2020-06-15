package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.face.DeptDao;
import dao.impl.DeptDaoImpl;
import dto.Dept;
import service.face.DeptService;

public class DeptServiceImpl implements DeptService {

	//DetpDao 객체 생성
	private DeptDao deptDao = new DeptDaoImpl();
	
	// Dept 테이블의 모든 데이터 조회
	@Override
	public List<Dept> deptList() {
		
		List<Dept> deptlist = deptDao.selectAll();
		
		return deptlist;
	}

	
	// Dept 테이블에 행 추가하기
	@Override
	public void addDept(Dept dept) {
		
		deptDao.insertDept(dept);	
		
	}

}
