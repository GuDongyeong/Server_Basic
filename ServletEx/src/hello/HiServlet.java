package hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 매개변수
		//	 HttpServletRequest : HTTP 요청 정보 객체
		//	 HttpServletResponse : HTTP 응답 정보 객체
		
		System.out.println("get 메소드 요청");
		
		// 응답 메시지의 형식을 알려주는 코드
		// -> html 문법의 text이며 한글 인코딩은 utf-8
		resp.setContentType("text/html;charset=utf-8");
		
		// 서버 -> 클라이언트(HTML)전달
		resp.getWriter().println("<h1>Hello Servlet</h1>");
		resp.getWriter().println("<h3>넘어렵다<h3>");
	
	
		// t서버 -> 콘솔로 전달
		System.out.println("콘솔 확인용, 테스트요 ㅇ스트림 출력");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
	
}
