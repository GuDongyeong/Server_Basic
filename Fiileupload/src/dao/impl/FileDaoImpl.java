package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
		// SQL  작성
		String sql = "";
		sql += "INSERT INTO uploadfile(fileno, origin_name, stored_name )";
		sql += " VALUES(uploadfile_seq.nextval, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql); // SQL 수행 객체 얻어오기
			
			// 파일 업로드 정보 삽입
			ps.setString(1, uploadFile.getOriginName());
			ps.setString(2, uploadFile.getStoredName());
			
			// SQL  수행
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps); // ps 자원해제
		}
		
		
	}

	@Override
	public List<UploadFile> selectAll() {
		
		conn = JDBCTemplate.getConnection();
		
		//SQL
		String sql = "";
		sql += "SELECT * FROM uploadfile";
		sql += " ORDER BY fileno DESC";
		
		List<UploadFile> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				UploadFile fileData = new UploadFile();
				
				fileData.setFileno(rs.getInt("fileno"));
				fileData.setOriginName(rs.getString("origin_name"));
				fileData.setStoredName(rs.getString("stored_name"));
				
				list.add(fileData);				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps); // ps 자원해제
		}
		
		
		return list;
	}

	@Override
	public int insertFile(Connection conn, UploadFile up) {
		
		//SQL 쿼리 작성
		String sql = "";
		sql += "INSERT INTO uploadfile( fileno, origin_name, stored_name)";
		sql += " VALUES(uploadfile_seq.nextval, ?, ?)";
		
		// insert 수행 결과를 저장할 변수
		int res = 0; 

		try {
			ps = conn.prepareStatement(sql); // SQL 수행 객체
			ps.setString(1, up.getOriginName());
			ps.setString(2, up.getStoredName());
			
			res = ps.executeUpdate(); // SQL 수행 및 결과 저장
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		//insert 수행 결과 반환
		return res;
	}


}
