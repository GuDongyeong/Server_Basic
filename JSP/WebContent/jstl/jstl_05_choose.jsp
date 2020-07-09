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

<h1>c:choose</h1>
<h3>전달 파라미터 choose페이지</h3>
<hr>

<c:choose>
	<c:when test="${param.sel eq 1 }">1을 선택하셨습니다.</c:when>
	<c:when test="${param.sel eq 2 }">2을 선택하셨습니다.</c:when>
	<c:when test="${param.sel eq 3 }">3을 선택하셨습니다.</c:when>
	<c:otherwise>
		1, 2, 3 중에 하나를 선택하세요!
	</c:otherwise>
</c:choose>

<h3><a href="./jstl_05.jsp">선택화면으로 돌아가기</a></h3>
</body>
</html>