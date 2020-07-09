<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/basicTag/header.jsp" />

<h1>c:import</h1>
<hr>

<%-- <c:import url="https://www.naver.com" /> --%>

<%-- <c:import url="https://www.youtube.com" /> --%>

<%-- <c:import url="https://search.naver.com/search.naver"> --%>
<%-- 	<c:param name="query" value="아아아" /> --%>
<%-- </c:import> --%>

<hr>

<c:redirect url="http://www.google.com"/>

<c:import url="/basicTag/footer.jsp" />

