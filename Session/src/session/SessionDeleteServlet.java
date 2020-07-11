package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/delete")
public class SessionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   // 세션 객체 얻기
	   HttpSession session = req.getSession();
   
	   // 세션 정보 삭제
	   session.invalidate();
	   
	   // VIEW 지정 - forward
	   req.getRequestDispatcher("/WEB-INF/views/session/delete.jsp").forward(req, resp);
   
   }
   

}
