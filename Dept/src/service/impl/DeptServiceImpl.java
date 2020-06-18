package service.impl;

import java.sql.Connection;

import dao.face.DeptDao;
import dao.impl.DeptDaoImpl;
import dbutil.DBConn;
import dto.Dept;
import service.face.DeptService;

public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	public Dept deptInfo(int deptno) {
		
		Connection conn = DBConn.getConnection();
		
		// DBConn이 2개 이상(계정이 다를 수도, oracle, MySQL)일 수 있기 때문에 conn을 service에서 전달해준다
		Dept dept = deptDao.selectOne(conn, deptno);
		
		return dept;
	}

}
