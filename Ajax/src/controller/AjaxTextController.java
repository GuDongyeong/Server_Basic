package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Member;

@WebServlet("/ajax/test")
public class AjaxTextController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/ajax/test.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println("/ajax/test [POST]");
		
		// 응답 데이터 형식 지정 - MIME 타입, 출력스트림 얻기 전에 쓰기
//		resp.setContentType("text/html; charset=utf-8");
		// json의 형식
		resp.setContentType("application/json; charset=utf-8");

		// 응답출력 스트림을 이용해 직접 보내기
		PrintWriter out = resp.getWriter();
		
		// - - - 데이터를 직접 출력(응답) 하기 - - -
//		out.println("Response Data Send"); // 단문 문자열 전송	
		
//		out.println("\"JSON DATA\""); // JSON Text, String 타입 전송 -=> 오류 날 수 도 있기 떄문에 무조건 Object 타입으로 보내야 한다
		
		// Object 형태로 키:값 쌍으로
//		out.println("{\"data\" : \"JSON DATA\"}"); // JSON Text, Object 타입

//		out.println("{\"cnt\" : 1 }"); // JSON Text, Object 타입
		
		// - - - - - - - - - - - - - - - - - - - - - 
		
		
		// - - - DTO 를 이용한 출력 (응답) - - -
		
		Member mem = new Member();
		mem.setId("Apple");
		mem.setPw("Banana");
		
		// 마샬링 및 응답 (Java DTO Object -> JSON Text )
//		out.println(new Gson().toJson(mem));
		// - - - - - - - - - - - - - - - - - - -
		
		//- - - List 를 이용한 응답 - - -
		List<Member> list = new ArrayList<>();
		
		Member m1 = new Member();
		m1.setId("A");
		m1.setPw("Apple");
		
		Member m2 = new Member();
		m2.setId("B");
		m2.setPw("Banana");
		
		list.add(m1);
		list.add(m2);
		
		out.println( new Gson().toJson(list));
		
		
		// - - - - - - - - - - - - - - -
		
	
	
	
	}

}
