package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.valves.JDBCAccessLogValve;

import dbutil.JDBCTemplate;
import web.dao.face.BoardFileDao;
import web.dto.Board;
import web.dto.BoardFile;

public class BoardFileDaoImpl implements BoardFileDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void delete(BoardFile board) {
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		//sql
		String sql = "";
		sql += "DELETE FROM boardfile";
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

}
