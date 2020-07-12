<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입 Form</h1>
<hr>

<%--  클라이언트 쪽이므로 컨텍스트 패스도 함꼐 넣어주어야 한다 --%>
<form action="<%=request.getContextPath() %>/board/insert" method="post">

<label>아이디<input type="text" name="uid" /></label><br>
<label>패스워드<input type="text" name="upw" /></label><br>

<button>가입</button>

</form>

</body>
</html>