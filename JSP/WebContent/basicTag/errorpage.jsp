<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 현재 JSP 페이지에서 에러처리할 수 있도록 만듦 --%>
<%-- exception 키워드(객체) 사용 가능  --%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 style="color: red;">에러 처리 페이지</h1>
<hr>

<!-- 예외 메시지 -->
<%=exception.getMessage() %><br>

<!-- 예외 클래스 -->
<%=exception.toString() %>


</body>
</html>