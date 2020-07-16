package web.dao.face;

import web.dto.Board;
import web.dto.BoardFile;

public interface BoardFileDao {

	/*
	 * 첨부파일 지우기
	 */
	public void delete(BoardFile board);

}
