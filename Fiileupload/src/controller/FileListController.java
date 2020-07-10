package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;
import service.face.FileService;
import service.impl.FileServiceImpl;

@WebServlet("/file/list")
public class FileListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private FileService fileService = new FileServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/file/list로 연결 - GET");
		
		List<UploadFile> list = fileService.list();
		
		// JSP 영역에 전달
		req.setAttribute("list", list);
		
		// VIEW로 포워딩
		req.getRequestDispatcher("/WEB-INF/views/file/list.jsp").forward(req, resp);
	
	
	
	}
   

}
