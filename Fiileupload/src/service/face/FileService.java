package service.face;

import java.io.File;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import dto.UploadFile;

public interface FileService {

	/**
	 * 파일 업로드 처리
	 * 	Commons-Fileupload 라이브러리 활용
	 * @param req - 요청정보 객체
	 * @param resp - 응답정보 객체
	 */
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);
	
	/**
	 * 파일 전체 리스트 꺼내오기
	 * @return - 파일 전체 리스트
	 */
	public List<UploadFile> list();
	
	/**
	 * 업로드된 파일 정보 기록하기
	 * @param up - 업로드된 파일의 정보
	 * @return int - DB에서 insert 수행한 결과
	 * 		0- insert 실패
	 *		1- insert 성공
	 */
	public int insertFile(UploadFile up);
	
	
}
