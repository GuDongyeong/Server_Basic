package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Member;
import web.service.face.MemberService;
import web.service.impl.MemberServiceImpl;

@WebServlet("/join/idcheck")
public class MemberIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Member m = new Member();
		
		m.setUserid(req.getParameter("id"));
		
		m = memberService.getMemberByUserid(m);
	
		PrintWriter out = resp.getWriter();

		if( m != null ) {
			out.println("{\"message\" : \"이미 사용중인 아이디입니다\", \"chk\":false }");
		} else {
			out.println("{\"message\" : \"사용가능한 아이디입니다\", \"chk\":true }");
		}
	}
	
}
