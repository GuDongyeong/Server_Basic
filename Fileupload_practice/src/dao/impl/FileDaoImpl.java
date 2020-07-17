package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.face.FileDao;
import dbutil.JDBCTemplate;
import dto.UploadFile;

public class FileDaoImpl implements FileDao {

	// OJDBC 관련 객체
		private Connection conn = null; /// DB 연결 객체
		private PreparedStatement ps = null; // SQL 수행 객체
		private ResultSet rs = null; // 조회 결과 처리 객체
		
	
	@Override
	public void insert(UploadFile uploadFile) {
		
		conn = JDBCTemplate.getConnection(); // DB 연결
		
		// SQL 작성
		String sql = "";
		sql += "INSERT INTO uploadfile(fileno, origin_name, stored_name)";
		sql += "VALUES(uploadfile_seq.nextval, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, uploadFile.getOriginName());
			ps.setString(2, uploadFile.getStoredName());
			
			// SQL 수행
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
		
	}

}
