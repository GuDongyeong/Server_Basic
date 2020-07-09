<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>fmt:formatDate</h1>
<hr>

<c:set var="now" value="<%=new Date() %>"/>

now : ${now }<br>
<hr>

dafault : <fmt:formatDate value="${now }" type="date" dateStyle="default"/><br>
short : <fmt:formatDate value="${now }" type="date" dateStyle="short"/><br>
medium : <fmt:formatDate value="${now }" type="date" dateStyle="medium"/><br>
long : <fmt:formatDate value="${now }" type="date" dateStyle="long"/><br>
full : <fmt:formatDate value="${now }" type="date" dateStyle="full"/><br>
<hr>

dafault : <fmt:formatDate value="${now }" type="time" timeStyle="default"/><br>
short : <fmt:formatDate value="${now }" type="time" timeStyle="short"/><br>
medium : <fmt:formatDate value="${now }" type="time" timeStyle="medium"/><br>
long : <fmt:formatDate value="${now }" type="time" timeStyle="long"/><br>
full : <fmt:formatDate value="${now }" type="time" timeStyle="full"/><br>

<hr>
<fmt:formatDate value="${now }" type="both"/><br>

<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="short"/><br>

<hr>
yyyy-MM-dd : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/><br>

HH:mm:ss.S : <fmt:formatDate value="${now }" pattern="HH:mm:ss.S"/><br>

<%-- java.util.Date : 고정된(상수) 시간을 저장 --%>
<%-- java.util.Calendar : 저장된 시간을 변경할 수 있음, 지정된 시간 저장 --%>

<%-- java.util.GregorianCalendar :  --%>

<%-- getTime() cal -> Date 형변환 --%>
<hr>
<c:set var="testTime" 
	value="<%=new GregorianCalendar(2020, 6, 2, 12,5, 8).getTime() %>" />

testTime : ${testTime }<br>


<hr>
<fmt:formatDate value="${testTime }" type="both" /><br>

<hr>
KK : <fmt:formatDate value="${testTime }" pattern="KK"/><br>

<hr>
a : <fmt:formatDate value="${testTime }" pattern="a"/><br>

<hr>
z : <fmt:formatDate value="${testTime }" pattern="z"/><br>
Z : <fmt:formatDate value="${testTime }" pattern="Z"/><br>
X : <fmt:formatDate value="${testTime }" pattern="X"/><br>

<hr>
<!-- 기준 : 현재 시간
시간 1 : 2020-06-01 10:43:23
시간 2 : 2020-05-12 15:13:57

<%-- 현재 시간과 비교해서  --%>
JSTL 이용해서 기준날짜와 같은 날은 시:분으로 출력
JSTL 이용해서 기준날짜 이전 날은 연-월-일 로 출력 -->

<%-- 현재 시간 변환 --%>
<c:set var="today" value="<%=new Date() %>" />
<fmt:formatDate var="td" value="${today }" pattern="yyyy-MM-dd"/>

<%-- 시간1 시간2를 Date클래스로 만들기 --%>
<c:set var="time1" value="<%=new GregorianCalendar(2020, 5, 1, 10, 43, 23).getTime() %>" />
<c:set var="time2" value="<%=new GregorianCalendar(2020, 4, 12,15, 13, 57).getTime() %>" />

<%-- 시간1, 시간2를 변환 --%>
<fmt:formatDate var="t1Str" value="${time1 }" pattern="yyyy-MM-dd" />
<fmt:formatDate var="t2Str" value="${time2 }" pattern="yyyy-MM-dd" />

<%-- <c:if test="${td eq t1Str }"> --%>
<%-- <fmt:formatDate value="${time1 }" pattern="hh:mm"/><br> --%>
<%-- </c:if> --%>

<%-- <c:if test="${td > t2Str }"> --%>
<%-- <fmt:formatDate value="${time2 }" pattern="MM-dd"/> --%>
<%-- </c:if> --%>



<c:choose>
	<c:when test="${t1Str lt td }">
		<fmt:formatDate value="${time1 }" pattern="yyyy-MM-dd"/><br>
	</c:when>
	<c:when test="${t1Str eq td }">
		<fmt:formatDate value="${time1 }" pattern="hh:mm"/><br>
	</c:when>
</c:choose>


<c:choose>
	<c:when test="${t2Str lt td }">
		<fmt:formatDate value="${time2 }" pattern="yyyy-MM-dd"/><br>
	</c:when>
	<c:when test="${t2Str eq td }">
		<fmt:formatDate value="${time2 }" pattern="hh:mm"/><br>
	</c:when>
</c:choose>

<hr>

</body>
</html>