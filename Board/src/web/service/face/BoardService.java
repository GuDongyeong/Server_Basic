package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Board;
import web.dto.BoardFile;
import web.util.Paging;

public interface BoardService {
	
	/**
	 * DB에서 게시판 정보 꺼내오기
	 * @return - 모든 게시판 정보
	 */
	public List<Board> list();
	
	/**
	 * 파라미터값 처리해주기
	 * @param req - 요청 객체
	 * @return - int boardno
	 */
	public Board getBoardno(HttpServletRequest req);
	
	/**
	 * 게시글 상세 정보 얻어오기
	 * @param b - boardno가 담긴 객체
	 * @return - 게시글 정보가 담긴 객체
	 */
	public Board view(Board b);

	/**
	 * 페이징 객체 생성
	 * @param req - 요청정보 객체
	 * @return - Paging 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * DB에서 게시판 정보 꺼내오기
	 * @param paging - 페이징 정보 객체
	 * @return - 모든 게시판 정보
	 */
	public List<Board> list(Paging paging);

	/**
	 * 게시글 저장하기
	 * @param b - 게시글 객체
	 */
	public void write(Board b);

	/**
	 * 첨부파일 저장
	 * @param req - 요청 객체
	 * @param resp - 응답 객체
	 */
	public void write(HttpServletRequest req, HttpServletResponse resp);

	/*
	 * 첨부 파일 정보 가져오기
	 */
	public BoardFile viewFile(int boardno);

	/*
	 * 게시글 삭제하기
	 */
	public void delete(Board board);

	/*
	 * board 정보 가져오기
	 */
	public Board getBoard(Board board);

	/*
	 * 게시글 수정하기
	 */
	public void update(HttpServletRequest req, HttpServletResponse resp, Board board);

}
