package form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.do")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("FormServlet /form.go - GET 요청");
		
		// JSP로 응답데이터를 만들기 - View
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("/WEB-INF/views/inputForm.jsp");
		
		// JSP를 이용한 응답 보내기
		rd.forward(req, resp); // 포워드, 포워딩
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 데이터의 한글 인코딩 UTF-8 설정
		// 요청 데이터를 받아 올때 웹이 한글을 UTF-8로 인식하도록 한다
		req.setCharacterEncoding("UTF-8");
		
		// 응답 데이터의 형식을 설정하기, JSP로 할떄는 넣어주면 안된다
		resp.setContentType("text/html; charset=utf-8");
		
		System.out.println("FormServlet /form.do - POST 요청");
		// rep 에 URL, Method, Parameter가 저장되어 있음
		
		// 전달 파라미터를 요청객체 req에서 꺼내기, 파싱한다
		
		// input 태그의 name을 매개변수로 넣어준다
		String uid = req.getParameter("uid");
		String upw = req.getParameter("upw");
		
		// 전달파라미터 확인(콘솔 출력)
		System.out.println("FormServlet POST uid : " + uid);
		System.out.println("FormServlet POST upw : " + upw);
		
		// 응답데이터 구성하기
		//	JSP 활용하지 않음
		//	Servlet으로 직접 응답을 작성하기
		
		PrintWriter out = resp.getWriter();
		
		out.append("<hr>")
			.append("<h1>전달받은 데이터</h1>")
			.append("<hr>")
			.append("<h3>아이디 : " + uid + "</h3>")
			.append("<h3>패스워드 : " + upw + "</h3>");
		
		// 응답용 VIEW JSP 지정하기
		
		// 응답 보내기(포워딩)
		
		
		
	
	}
	
}
