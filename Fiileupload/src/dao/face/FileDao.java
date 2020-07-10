package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.UploadFile;

public interface FileDao {

	
	/**
	 * 
	 * @param uploadFile
	 */
	public void insert(UploadFile uploadFile);
	
	
	/**
	 * 파일 리스트 전체 가져오기
	 * @return - 리스트
	 */
	public List<UploadFile>  selectAll();


	/**
	 * 파일정보 DB에 insert 수행
	 * @param conn - DB 연결객체
	 * @param up - 업로드된 파일 정보
	 * @return int - insert 수행 결과
	 * 		1 - insert 성공
	 * 		0 - insert 실패
	 */
	public int insertFile(Connection conn, UploadFile up);

}


