package controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/login [GET]");
		
		// VIEW 포워딩
		req.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/login/login [POST]");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		
		// 포워드될 URL(VIEW)
		String url = null;
		
		// 세션 객체 생성
		HttpSession session = req.getSession();
		
		// 로그인 인증(Authentication, auth)
		if( "abc".equals(id) && "123".equals(pw)) {
			
			// 로그인 성공
			url = "/WEB-INF/views/login/loginSuccess.jsp";
			
			session.setAttribute("login", true); // 로그인 상태, login=true
			session.setAttribute("loginid", id); // 로그인 아이디
			
		} else {

			// 로그인 실패
			url = "/WEB-INF/views/login/loginFail.jsp";
			
		}
	
		// VIEW 지정 - forward
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
}
