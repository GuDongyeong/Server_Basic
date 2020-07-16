package web.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.dto.BoardFile;
import web.dto.Member;
import web.service.face.BoardService;
import web.service.face.MemberService;
import web.service.impl.BoardServiceImpl;
import web.service.impl.MemberServiceImpl;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// boardno 파라미터값 처리
		Board b = boardService.getBoardno(req);
		
		int boardno = b.getBoardno();		
		
		// 게시글 상세 정보 얻어오기
		Board board = boardService.view(b);
		
		// 첨부파일 정보 얻어오기
		BoardFile bf = boardService.viewFile(boardno);
		System.out.println(bf);
		
		// 작성자 정보 얻어오기
		Member m = new Member();
		m.setUserid(board.getId());
		
		Member mem = memberService.getMemberByUserid(m);
		
		if( bf != null ) {
			String path = getServletContext().getRealPath("upload") + "\\" + bf.getStoredname();
			System.out.println(path);
			req.setAttribute("path", path);
			req.setAttribute("boardfile", bf);
		}
		
		// JSP에 값 전달
		req.setAttribute("board", board);
		req.setAttribute("member", mem);
		
		req.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(req, resp);
				
	
	
	}
	

}
