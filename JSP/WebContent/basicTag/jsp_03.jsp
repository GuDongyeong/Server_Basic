<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>하하하</h3>
<hr>

<% int num = 123; // _jspService() 메소드의 지역 변수 선언

	// out == reponse.getWriter()
	out.print("브라우저 : " + num + "<br>"); // 응답출력 스트림 -> 브라우저
	
	System.out.print("이클립스 : " + num); // 이클립스 콘솔 출력

%>
<br>
<%="표현식 : " + num %><br>

<h1><%="태그 안쪽에서 사용" %></h1>

</body>
</html>