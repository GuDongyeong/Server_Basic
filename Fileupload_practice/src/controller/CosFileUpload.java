package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@WebServlet("/cos/fileupload")
public class CosFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cos/fileupload [GET]");
		
		// VIEW 지정 포워드
		req.getRequestDispatcher("/WEB-INF/views/cos/fileupload.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cos/fileupload [POST]");
	
		// enctype="multipart/form-data"인지 검증
		//	아닐경우의 처리
		if( !ServletFileUpload.isMultipartContent(req)) {
			
			req.setAttribute("message", "form 의 enctyp e 속성이 안맞습니다");
			// 에러처리 전용  View(JSP) 만들어서 응담 - forward
			req.getRequestDispatcher("/WEB-INF/views/file/error.jsp").forward(req, resp);
			
			return;
			
		}
		
		//- - - - -매개변수 준비 - - - - - - -
		// 1. 요청객체 - req
		
		// 2. 파일 저장 위치
		ServletContext context = getServletContext();
		String saveDirectory = context.getRealPath("upload");
		
		// 3. 업로드 제한 사이즈 - 10MB
		int maxPostSize = 10 * 1024 * 1024;
		
		// 4. 인코딩
		String encoding = "UTF-8";
		
		// 5. 중복된 파일이름 처리할 정책
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		// ** DefaultFileRenamePolicy
		//	이미 업로드된 파일 중에 같은 이름이 있으면 새롭게 업로드된 파일이름 번호를 붙여준다
		
		//------------------------------------
		
		// - - - COS 파일 업로드 객체 생성 - - -
		
		MultipartRequest mul = new MultipartRequest(
				req
				, saveDirectory
				, maxPostSize
				, encoding
				, policy				
				);
		
		// **  MultipartRequest 객체가 생성되면서 파일 업로드가 수행됨
		
		// - - - -  - - - - - - - - - - - - - - -
		
		// 파일명 - 년월일시분초밀리조
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS");
		String rename = sdf.format(new Date());
		
		// 확장지
		String origin = mul.getOriginalFileName("upfile") ; // 원본 파일명
		String ext = origin.substring(origin.lastIndexOf(".")+1);
		
		//저장될 이름
		String stored = rename + "." + ext;
		
		System.out.println("[TEST] stored file name : " + stored);
	
	}
	
	
}
