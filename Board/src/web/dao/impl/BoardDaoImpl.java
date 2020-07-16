package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.JDBCTemplate;
import jdk.nashorn.internal.scripts.JD;
import web.dao.face.BoardDao;
import web.dto.Board;
import web.dto.BoardFile;
import web.util.Paging;

public class BoardDaoImpl implements BoardDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Board> selectAll() {
		
		// 결과값 객체
		List<Board> list = new ArrayList<>();
		
		// sql 구문
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " ORDER BY boardno DESC";
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql);
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Board b = new Board();
				
				b.setBoardno(rs.getInt("boardno"));
				b.setTitle(rs.getString("title"));
				b.setId(rs.getString("id"));
				b.setContent(rs.getString("content"));
				b.setHit(rs.getInt("hit"));
				b.setWrittendate(rs.getDate("writtendate"));
				
				list.add(b);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}

	@Override
	public Board selectBoardByBoardno(Board b) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " WHERE boardno = ?";
		
		// 결과 객체
		Board res = new Board();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, b.getBoardno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				res.setBoardno(rs.getInt("boardno"));
				res.setTitle(rs.getString("title"));
				res.setId(rs.getString("id"));
				res.setContent(rs.getString("content"));
				res.setHit(rs.getInt("hit"));
				res.setWrittendate(rs.getDate("writtendate"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public void updateHit(Board b) {
		
		// DB연결
		conn = JDBCTemplate.getConnection();
		
		// sql 작성
		String sql = "";
		sql += "UPDATE board SET hit = hit + 1";
		sql += " WHERE boardno = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, b.getBoardno());
			
			ps.executeUpdate();
			
			JDBCTemplate.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
	}

	@Override
	public int selectCntAll() {
		
		// DB연결
		conn = JDBCTemplate.getConnection();
		
		// sql 작성
		String sql = "";
		sql += "SELECT count(*) FROM board";

		// 결과 저장할 변수
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			// 조회 결과 처리
			while( rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return totalCount;
	}
	
	@Override
	public List<Board> selectAll(Paging paging) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();

		// 결과값 객체
		List<Board> list = new ArrayList<>();
		
		// sql 구문
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM(";
		sql += "		SELECT boardno, title, id, content, hit, writtendate";
		sql += "		FROM board";
		sql += "		ORDER BY boardno DESC";
		sql += "	) B";
		sql += " ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Board b = new Board();
				
				b.setBoardno(rs.getInt("boardno"));
				b.setTitle(rs.getString("title"));
				b.setId(rs.getString("id"));
				b.setContent(rs.getString("content"));
				b.setHit(rs.getInt("hit"));
				b.setWrittendate(rs.getDate("writtendate"));
				
				list.add(b);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}

	@Override
	public void insert(Board b) {
		
		// DB연결
		conn = JDBCTemplate.getConnection();
		
		// sql 작성
		String sql = "";
		sql += "INSERT INTO board(boardno, title, id, content, hit)";
		sql += " VALUES(?, ?, ?, ?, 0)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, b.getBoardno());
			ps.setString(2, b.getTitle());
			ps.setString(3, b.getId());
			ps.setString(4, b.getContent());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}

	@Override
	public int selectBoardno() {
		
		// 결과 저장 객체
		int boardno = 0;
		
		// sql
		String sql = "";
		sql += "SELECT board_seq.nextval FROM dual";
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				boardno = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return boardno;
	}

	@Override
	public void insertFile(BoardFile boardFile) {
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "INSERT INTO boardfile(fileno, boardno, originname, storedname, filesize)";
		sql += " VALUES(boardfile_seq.nextval, ?, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, boardFile.getBoardno());
			ps.setString(2, boardFile.getOriginname());
			ps.setString(3, boardFile.getStoredname());
			ps.setInt(4, boardFile.getFilesize());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}

	@Override
	public BoardFile selectFile(int boardno) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM boardfile";
		sql += " WHERE boardno = ?";
		
		// 결과 객체
		BoardFile res = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, boardno);
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				res = new BoardFile();
				
				res.setFileno(rs.getInt("fileno"));
				res.setBoardno(rs.getInt("boardno"));
				res.setOriginname(rs.getString("originname"));
				res.setStoredname(rs.getString("storedname"));
				res.setFilesize(rs.getInt("filesize"));
				res.setWritedate(rs.getDate("writedate"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public void delete(Board board) {
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		//sql
		String sql = "";
		sql += "DELETE FROM board";
		sql += " WHERE boardno=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}

	@Override
	public void update(Board b) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "UPDATE board SET ";
		sql += " title=?";
		sql += ", content=?";
		sql += " WHERE boardno=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getContent());
			ps.setInt(3, b.getBoardno());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}

}
