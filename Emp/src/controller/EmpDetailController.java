package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService = new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 접속 확인
//		System.out.println("EmpDetailController - /emp/detail [GET]");
		
		// 전달파라미터 eno 추출
		String param = req.getParameter("eno");
		
		int empno = 0;
		
		if( param != null && !"".equals(param)) {
			empno = Integer.parseInt(param);
		}
		
		System.out.println ("EmpDetailController - empno : " + empno);
		
		Emp emp = new Emp();
		emp.setEmpno(empno);
		
		// 사원 정보를 상세 조회
		Emp result = empService.detail(emp);
		
		System.out.println("EmpDetailController - result : " + result);
		
		// 조회결과(Model) 값을 View에 전달하기 - request 객체 사용
		req.setAttribute("res", result);
		
		// VIEW를 지정하고 응답하기(포워딩) - request 객체 사용
		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp")
				.forward(req, resp);
		
		
	
	}
	
	

}
