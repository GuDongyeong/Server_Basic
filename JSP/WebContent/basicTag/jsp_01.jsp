<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
console.log("Javascript");
</script>

</head>
<body>

<h3>Hello World!</h3>

<% String name = "Alice";
	System.out.println(name); // 이클립스 콘솔 출력%>

<%-- JSP 주석 --%>
<!-- HTML 주석 -->

<%-- 스크립트릿 태그, 자바코드를 작성하는 영역 --%>
<% 
	// 자바 주석 사용 가능
	/* 자바코드를 작성할 수 있는 영역이니까 자바 주석을 사용할 수 있다 */
	
	
%>

<%	String scriptlet = "HI";
	System.out.println(scriptlet.length());
%>

<hr>
<%	out.print("브라우저 출력"); // out == resp.getWriter() %>

<hr>
<% for(int i=0;i<3;i++){ %>
<h3>스크립트릿 + HTML</h3>
<% } %>

<hr>

<%
	// 메소드 정의 불가
// 	public void method(){
// 	}

	// 접근제한자를 이용한 변수 선언 불가
	// private int num = 10;
%>
</body>
</html>