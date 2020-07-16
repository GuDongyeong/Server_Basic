package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Member;
import web.service.face.MemberService;
import web.service.impl.MemberServiceImpl;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	// view 포워딩
	req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
		// 로그인 폼 정보 객체
		Member m = memberService.getLoginMember(req);
		
		// DB와 비교하여 로그인 확인받기
		boolean login = memberService.login(m);
		
		if( login ) {
		
			// 회원정보 가져오기
			m = memberService.getMemberByUserid(m);
			
			// 세션 정보 객체 얻기
			HttpSession session = req.getSession();

			// 세션에 회원 정보 저장
			session.setAttribute("login", login);
			session.setAttribute("userid", m.getUserid());
			session.setAttribute("usernick", m.getUsernick());
			
			// view 리다이렉트
			resp.sendRedirect("/main");
			
		}else {
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인 정보가 잘못되었습니다.');"
					+ "history.go(-1);</script>");
		}
		
	}

}
