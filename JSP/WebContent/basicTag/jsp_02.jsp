<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!	private int age = 11; // 접근제한자 적용 가능	%>

<%-----------------------------------------------%>

<%! String name = "Alice"; //멤버 필드	%>
<% String hobby = "Soccer"; // _jspService() 메소드의 지역변수 %>
    
<%-----------------------------------------------%>
    
<%! // 메소드 정의
	public void method(){
		System.out.println("Hello " + name);	
	}
%>

<%	method(); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>