package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.service.face.BoardService;
import web.service.impl.BoardServiceImpl;
import web.util.Paging;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/board/list [GET]");
	
		// 요청 파라미터를 전달하여 Paging 객체 생성하기
		Paging paging = boardService.getPaging(req);
//		System.out.println("BoardListController =" + paging);
		
		//DB에서 게시판 리스트 꺼내오기
//		List<Board> list = boardService.list();
		List<Board> list = boardService.list(paging);
		
		// list data VIEW 로 넘겨주기
		req.setAttribute("list", list);
		
		// Paging 처리 결과 Model 값 전달
		req.setAttribute("paging", paging);
		
		// VIEW 포워딩
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
		
		
	
	}

}
