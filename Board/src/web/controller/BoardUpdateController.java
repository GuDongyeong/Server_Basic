package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Board;
import web.dto.BoardFile;
import web.dto.Member;
import web.service.face.BoardService;
import web.service.face.MemberService;
import web.service.impl.BoardServiceImpl;
import web.service.impl.MemberServiceImpl;

@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Board board = boardService.getBoardno(req);
		
		board = boardService.getBoard(board);
		
		System.out.println(board);
		// 첨부파일 정보 얻어오기
		BoardFile bf = boardService.viewFile(board.getBoardno());
		
		if( bf != null ) {
			req.setAttribute("boardfile", bf);
		}
		req.setAttribute("board", board);
		
		req.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Board board = new Board();
		board.setBoardno((int)session.getAttribute("boardno"));

		// 파일 수정
		boardService.update(req, resp, board);
		
		// 리다이렉트
		resp.sendRedirect("/board/list");
	
	}

}
