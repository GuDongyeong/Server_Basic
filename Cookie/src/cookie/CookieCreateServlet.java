package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/create")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cookie/create [GET]");
	
		Cookie c1 = new Cookie("ID", "Ali"); // 쿠키 객체 생성
		
		resp.addCookie(c1); // 쿠키를 클라이언트로 보내는 코드

		Cookie c2 = new Cookie("PASS", "1234"); // 쿠키 객체 생성
		
		resp.addCookie(c2); // 쿠키를 클라이언트로 보내는 코드
		
		Cookie c3 = new Cookie("NAME", "alice"); // 쿠키 객체 생성
		
		resp.addCookie(c3); // 쿠키를 클라이언트로 보내는 코드
		
		req.getRequestDispatcher("/WEB-INF/views/cookie/create.jsp").forward(req, resp);
		
		
		
	
	}
	
	
	
	

}
