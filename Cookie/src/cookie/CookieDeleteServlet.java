package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/delete")
public class CookieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 쿠키 삭제 방법
		//	쿠키의 maxAge(쿠키 유지 시간)를 0으로 설정한다
	
		// 요청된 쿠키 정보 얻기
		Cookie[] cookies = req.getCookies();
		
		// 요청된 모든 쿠키의 maxAge를 변경한 후 다시 클라이언트에게 전달한다
		for(int i = 0; i<cookies.length;i++) {
//			cookies[i].setMaxAge(0); // 즉시 삭제로 설정
//			cookies[i].setMaxAge(3); // 3초로 설정
			cookies[i].setMaxAge(24*60*60); // 하루
			
			resp.addCookie(cookies[i]); // 클라이언트에게 쿠키 전달
		}
		
		// VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/cookie/delete.jsp").forward(req, resp);
		
	}
	
}
