package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

@WebServlet("/member/join")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//MemberService 객체 생성
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//접속 테스트
		System.out.println("/member/join GET - 요청 완료");
		
		//View를 지정하고 응답하기(forward)
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//접속 테스트

		System.out.println("/member/join POST - 요청 완료");
		
		//1.POST 데이터 한글 인코딩 설정 (UTF-8)
		req.setCharacterEncoding("UTF-8");
		
		//2.요청파라미터를 Member DTO에 저장하기
		//  Service 이용 ( userid , nick , email)
		Member member = memberService.getParam(req);
		System.out.println("memberController - "+ member);
		
		//3. Member DTO를 데이터베이스에 입력
		//  Service 이용
		//  입력된 정보(userno포함)를 반환받기
		Member result = memberService.join(member);
		System.out.println("MemberController result - "+result);
		
		//4. DB에 입력된 데이터를 VIEW에 전달하기
		//  request 객체 이용
		req.setAttribute("result", result);
		
		//5. VIEW를 지정하고 응답하기(forward)
		req.getRequestDispatcher("/WEB-INF/views/member/result.jsp").forward(req, resp);
	}
	
	
}
