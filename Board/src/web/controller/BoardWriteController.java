package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Board;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션 객체
		HttpSession session = req.getSession();

		if( session.getAttribute("login") == null ) {
			resp.sendRedirect("/");
		}else if( (boolean) session.getAttribute("login")) {
			req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		Board b = new Board();
		
		// form 전달 파라미터 board 객체에 저장
//		b.setTitle(req.getParameter("title"));
//		b.setContent(req.getParameter("content"));
		
		// 세션 아이디 저장
//		b.setId((String) session.getAttribute("userid"));
		
		// DB에 전달
//		boardService.write(b);
		
		// 파일 업로드
		boardService.write(req, resp);
		
		// 리다이렉트
		resp.sendRedirect("/board/list");
		
	}
	
}
