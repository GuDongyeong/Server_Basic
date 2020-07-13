package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/view")
public class CookieViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 쿠키 정보 전체 가져오기
		Cookie[] cookies = req.getCookies();
	
		// 모든 쿠키 출력
		for(int i=0;i<cookies.length;i++) {
//			System.out.println(cookies[i]);
			System.out.println(cookies[i].getName() + "="
								+ cookies[i].getValue());
		}
		
		//VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/cookie/view.jsp").forward(req, resp);
	
	}
	
	
	
}
