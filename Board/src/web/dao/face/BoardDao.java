package web.dao.face;

import java.util.List;

import web.dto.Board;
import web.dto.BoardFile;
import web.util.Paging;

public interface BoardDao {
	
	/**
	 * 게시글 전체 조회
	 * @return
	 */
	public List<Board> selectAll();
	
	/**
	 * 게시글 상세 정보 얻어오기
	 * @param b - boardno가 담긴 Board객체
	 * @return - 게시글 상세정보
	 */
	public Board selectBoardByBoardno(Board b);
	
	/**
	 * 게시글 조회수 + 하기
	 * @param b - 조회수 올라간 board 객체
	 */
	public void updateHit(Board b);

	/**
	 * 총 게시글 수 조회
	 * @return - 전체 게시글 수
	 */
	public int selectCntAll();
	
	/**
	 * 게시글 전체 조회
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 조회된 게시글 목록
	 */
	public List<Board> selectAll(Paging paging);

	/**
	 * 게시글 저장
	 * @param b - 게시글 객체
	 */
	public void insert(Board b);

	/*
	 * board pk 가져오기 
	 * @return - 시퀀스 값
	 */
	public int selectBoardno();

	/*
	 * 첨부파일 정보 DB에 기록하기
	 */
	public void insertFile(BoardFile boardFile);

	/*
	 * 첨부파일 정보 꺼내오기
	 */
	public BoardFile selectFile(int boardno);

	/*
	 * DB에서 게시글 삭제하기
	 */
	public void delete(Board board);

	/*
	 * DB 수정하기
	 */
	public void update(Board b);

}
