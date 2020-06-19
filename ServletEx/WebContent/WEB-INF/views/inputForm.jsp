<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>JSP 응답!</h1>
<hr>

<form action="/form.do" method="post">
<lable for"userid">아이디</lable>
<input type="text" id="userid" name="uid"/><br>

<lable for="userpw">패스워드</lable>
<input type="text" id="userpw" name="upw"/><br><br>

<input type="submit" value=" 로그인"/>
</form>

</body>
</html>