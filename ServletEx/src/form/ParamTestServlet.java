package form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/param")
public class ParamTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/param - GET 요청 완료");
		
		String data1 = req.getParameter("data1");
		System.out.println("data1 : " + data1);
		
		String data2 = req.getParameter("data2");
		System.out.println("data2 : " + data2);
		
		// 응답객체를 이용한 클라이언트 출력
		resp.getWriter().println("<h1>data1 : " + data1 + "</h1>");
		
		
	
	}
	
	
}
