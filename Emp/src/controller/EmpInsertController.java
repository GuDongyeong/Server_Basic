package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

@WebServlet("/emp/insert")
public class EmpInsertController extends HttpServlet {
	
	private EmpService empService = new EmpServiceImpl();
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EmpInsertController /emp/insert - GET 요청");
		
		// VIEW 지정하기 및 응답하기(포워딩)
		req.getRequestDispatcher("/WEB-INF/views/emp/insert.jsp")
			.forward(req, resp); 
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("EmpInsertController /emp/insert - POST 요청");
		
		// 요청 파라미터 정보 얻기
		Emp emp = empService.getEmpParam(req);
		System.out.println("EmpInsertController - emp : " + emp);
			
		// 사원정보 DB에 추가하기		
		empService.join(emp);
		
		
		//결과화면 이동 - 목록 페이지로 이동
		resp.sendRedirect("/emp/list");
		
		
	}

}
