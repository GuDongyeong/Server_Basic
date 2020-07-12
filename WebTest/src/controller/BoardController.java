package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/insert [GET]");
	
		// 자기자신을 찾기 때문에 /kh 를 쓰지 않아도된다
		req.getRequestDispatcher("/views/board/insert.jsp").forward(req, resp);
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/board/insert [POST]");
		
		
		
		System.out.println("아이디 : " +req.getParameter("uid"));
		System.out.println("비밀번호 : " +req.getParameter("upw"));
	
	}

}
