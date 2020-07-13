package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/update")
public class CookieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie c1 = new Cookie("ID", "boo");
		
		resp.addCookie(c1); // 클라이언트에게 쿠키 전달하기, 똑같은 키 이름으로 하면 수정된다

		Cookie c2 = new Cookie("PASS", "13544");
		
		resp.addCookie(c2); // 클라이언트에게 쿠키 전달하기, 똑같은 키 이름으로 하면 수정된다

		Cookie c3 = new Cookie("name", "Bob");
		
		resp.addCookie(c3); // 클라이언트에게 쿠키 전달하기, 똑같은 키 이름으로 하면 수정된다
	
		req.getRequestDispatcher("/WEB-INF/views/cookie/update.jsp").forward(req, resp);
	
	}
	
}
