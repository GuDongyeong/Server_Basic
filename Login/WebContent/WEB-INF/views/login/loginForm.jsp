<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인</h1>
<hr>

<%-- 비로그인 상태 --%>
<c:if test="${empty login }">
<form action="/login/login" method="post">
	
<label>아이디 <input type="text" name="id" /></label><br>
<label>비밀번호 <input type="text" name="pw" /></label><br><br>

<button>로그인</button>
<!-- <button type="button">로그아웃</button> -->
<!-- <input type="button" value="로그아웃" /> -->
</form>
</c:if>

<%-- 로그인 상태 --%>
<c:if test="${login }">
<button onclick="location.href='/login/logout'">로그아웃</button>
</c:if>

</body>
</html>