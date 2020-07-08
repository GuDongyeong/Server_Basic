package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService = new EmpServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 접속 테스트
		System.out.println("EmpListController /emp/list - GET 요청");
		
		// Emp 테이블의 전체 목록을 조회 - EmpService  이용
		List<Emp> empList = empService.list();
		
		//[TEST]의 조회 결과 출력 - Console
//		for( Emp e : empList) {
//			System.out.println(e);
//		}
		
		// View에 조회 결과 (Model값)를 전달
		//	JSP에 "list"라는 이름으로 empList 전달
		req.setAttribute("list", empList);
		
		
		
		// JSP를 View로 지정하고 응답으로 사용하기 포워딩
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("/WEB-INF/views/emp/list.jsp");
		rd.forward(req, resp);
	
	
	
	}
	
}
