package session;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/view")
public class SessionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 세션 객체 얻기
		HttpSession session = req.getSession();
		
		// 세션 정보 출력
		System.out.println("test : " + session.getAttribute("test"));
		
		System.out.println("--------------------");
		
		// 세션 관련 정보 확인하기
		
		// 지금 관리되고 있는 세션 아이디
		System.out.println("Session ID : " + session.getId());
		
		// 세션 생성 시간 , 반환타입 long, 밀리초이기 떄문에 변형을 해줌
		System.out.println("CreationTime : " + new Date(session.getCreationTime()) );
		
		// 세션 최근(마지막) 접속 시간 , 반환타입 long, 밀리초이기 떄문에 변형을 해줌
		System.out.println("LastAccessedTime : " + new Date(session.getLastAccessedTime()) );
		
		// 세션 유지시간 세션시간(서버에 접속해서 아무것도 하지 않은 시간), 최대 비활동간격(아므것도 하지 않고 흘러갈 수 있는 간격 최대)
		// 클라이언트가 접속하고 나서 아무것도 하지 않는시간, 이 시간이 지나면 로그아웃됨
		System.out.println("MaxInactiveInterval : " + session.getMaxInactiveInterval());
		
		// 세션이 새롭게 생성된 것인지 판단
		System.out.println("isNew : " + session.isNew());
		
		System.out.println("--------------------");
		
		// VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/session/view.jsp").forward(req, resp);
				
	
	}

}


