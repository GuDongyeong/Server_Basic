package gson;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Person;

@WebServlet("/gson_02")
public class GsonTest_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/gson02 [get]");
		
		// Gson 라이브러리 객체
		Gson gson = new Gson();
		
		// 테스트용 객체 생성
		Person p1 = new Person();
		System.out.println(p1);
		
		
		// p1 객체를  JSON 으로 마샬링
		String jsonText = gson.toJson(p1);
		System.out.println(jsonText);
		
		System.out.println("----------------------------");
		
		String test = "{\"name\":\"Alice\",\"age\":20,\"addr\":\"Seoul\"}";
		
		// JSON Text를 p2 로 언마샬링
		Person p2 = gson.fromJson(test, Person.class);
		System.out.println(p2);
		
		System.out.println("----------------------------");

		HashMap<String, Object> map = new HashMap<>();
		
		map.put("name", "Bob");
		map.put("age", 30);
		map.put("addr", "Busan");
		map.put("phone", "12345678990");
		
		map.put("p", new Person());
		
		System.out.println("--- map ---");
		System.out.println( map);
		
		System.out.println("--- toJson(map)---");
		System.out.println(gson.toJson(map));
		
	}

}
