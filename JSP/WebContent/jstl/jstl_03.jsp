<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>c:set</h1>
<hr>

<%-- 세션 컨텍스트 정보 삽입 --%>
<c:set var="sessionData" value="SESSION_DATA_123123" scope="session" />

<a href="./jstl_03_session.jsp">세션 확인</a>

<hr>
<% Map map = new HashMap(); //Java 영역 %>

map : ${map }<br><br> <%-- Context 영역을 찾음 --%>
map : <%=map %>

<%-- JSTL을 이용한 Map 객체의 프로퍼티 삽입( map.put(key, value) ) --%>
<c:set target="<%=map %>" property="A" value="Alice" />
<c:set target="<%=map %>" property="B" value="Bob" />

A Key : <%=map.get("A") %><br> 
B Key : ${map.B }<br>

<hr>

<%-- JTSL을 이용하여 session 컨텍스트 정보로 map 객체 등록하기 --%>
<c:set var="m" value="<%=map %>" scope="session" />

m : ${m }<br>

<hr>
<%-- Java, Page 둘다 생성됨 --%>
<jsp:useBean id="userBean" class="dto.User" />

<%-- 자바빈의 프로퍼티에 값 넣기 --%>
<jsp:setProperty property="id" name="userBean" value="AAA"/>
<c:set target="${userBean }" property="pw" value="BBB" />

user : ${userBean }<br>

<%-- JSTL을 이용하여 자바빈 userBean을 세션정보로 등록하기 --%>
<c:set var="sessionUser" value="${userBean}" scope="session" />

<hr>

<%-- 모든 컨텍스트 영역에서 "sessionData"로 등록된 변수 제거 --%>
<c:remove var="sessionData" />

<%-- 모든 컨텍스트 영역에서 "sessionData"로 등록된 변수 제거 --%>
<c:remove var="sessionData" scope="session"/>

<% session.removeAttribute("sessionData"); %>





</body>
</html>