package dao.face;

import dto.UploadFile;

public interface FileDao {
	
	/**
	 * 파일 DB에 올리기
	 * @param uploadFile - 올릴 파일 원본명, 재설정한 이름
	 */
	public void insert(UploadFile uploadFile);

}
