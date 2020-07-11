package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/create")
public class SessionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// SESSION_ID 는 톰캣이 알아서 생성함
		
		//  세션 정보만 생성해서 처리하면 된다
		HttpSession session = req.getSession(); // 세션 객체 생성
		
		session.setAttribute("test", "Apple"); // 세션 정보 저장
		
		// 세션 유지 시간 변경하기
//		session.setMaxInactiveInterval(0); // 0초 == 무제한, 실제로는 절대 하지 말것
		session.setMaxInactiveInterval(5); // 5초
//		session.setMaxInactiveInterval(1*60*60); // 1hour
		
		// VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/session/create.jsp").forward(req, resp);
		
	}
}
