package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.FileService;
import service.impl.FileServiceImpl;

@WebServlet("/commons/fileupload")
public class CommonsFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/commons/fileupload - GET 요청");
	
		// VIEW 지정 - 파일 업로드 <form>페이지 띄우기(포워드)
		req.getRequestDispatcher("/WEB-INF/views/commons/fileupload.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// application/x-www-form-urlencoded 인코딩 방식으로 전달된 요청 파라미터는 req.getParameter() 메소드를 통해 얻을 수 있지만
		//	multipart/form-data 인코딩 방식으로 전달된 요청 파라미터는 req.getParameter() 메소드에서 null만 반환한다
		
		//- > 파일업로드 라이브러리를 활용해서 처리해야 한다
		
		// 서비스 객체를 이용한 파일 업로드 처리
		fileService.fileupload(req,resp);
	
	
	}
	
	

}
