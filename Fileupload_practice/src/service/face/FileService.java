package service.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {

	/**
	 * 파일 업로드 처리
	 *  commons-fileupload 라이브러리 활용
	 * @param req - 요청정보 객체
	 * @param resp - 파일전체 리스트
	 */
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);
}
