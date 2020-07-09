<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>액션 태그 테스트</h1>
<h3>useBean</h3>
<h3>setProperty, getProperty</h3>
<hr>

<% 
	// 스크립트릿을 이용한 객체 생성
	User user1 = new User();

	// 페이지 컨텍스트에 user1 객체를 저장한다
// 	pageContext.setAttribute("user1", user1);

	// request 컨텍스트에 user1 객체를 저장한다
	request.setAttribute("user1", user1);
%>

<%-- 액션태그를 이용한 JavaBean 생성 - page 영역에 생성됨 --%>
<jsp:useBean id="user2" class="dto.User" scope="session"></jsp:useBean>

<%-- JavaBean의 프로퍼티 값 설정하기 --%>
<%-- user1.setId("id1")를 의도한 것 --%>
<jsp:setProperty property="id" name="user1" value="id1"/><%-- null값이라 서버 널포인트 익셉션 -> 500 --%>
<jsp:setProperty property="pw" name="user1" value="pw1"/>

<jsp:setProperty property="id" name="user2" value="id2"/>
<jsp:setProperty property="pw" name="user2" value="pw2"/>

<%-- 자바 영역의 객체 출력하기, 이거는 컨텍스트의 영향을 받지 않음 --%>
user1 : <%=user1 %><br>
user2 : <%=user2 %><br>

<hr>
<%-- page 컨텍스트 영역에서 user1, user2 찾아서 출력하기 --%>
[page 컨택스트] user1 : <%=pageContext.getAttribute("user1") %><br>
[page 컨택스트] user2 : <%=pageContext.getAttribute("user2") %><br>
<hr>
<%-- session 컨텍스트 영역에서 user1, user2 찾아서 출력하기, 각 컨텍스트 범위는 겹치지 않음, session에도 따로 저장해주어야한다 --%>
[session 컨택스트] user1 : <%=session.getAttribute("user1") %><br>
[session 컨택스트] user2 : <%=session.getAttribute("user2") %>

<hr>
<%-- 프로퍼티 값 가져오기 --%>
user1.id : <%=((User)request.getAttribute("user1")).getId() %><br>
<%-- user1.pw : <jsp:getProperty property="pw" name="user1"/><br> --%><%-- 컨텍스트 영역에 넣었다고 해서 모두 자바 빈이 아니다(getProperty()는 사용 안됨) --%>

<hr>
user2.id : <jsp:getProperty property="pw" name="user2"/><br>
user2.pw : <%=((User)session.getAttribute("user2")).getId() %><br>




</body>
</html>