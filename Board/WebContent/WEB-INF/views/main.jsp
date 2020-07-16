<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<c:import url="/WEB-INF/views/layout/header.jsp" />
<style>
div{
	text-align: center;
}
</style>

<div class="container">
<h1>Main</h1>
<hr>

<c:choose>
<c:when test="${login }">
	<div>
		<strong>${usernick }님 안녕하세요</strong><br>
	
		<button onclick="location.href='/board/list'">게시판 목록</button>
		<button onclick="location.href='/member/logout'">로그아웃</button>
	</div>
</c:when>
<c:when test="${not login }">
	<div>
		<button onclick="location.href='/member/login'">로그인</button>
		<button onclick="location.href='/member/join'">회원가입</button>
	</div>
</c:when>


</c:choose>

<hr>
</div>


<c:import url="/WEB-INF/views/layout/footer.jsp" />