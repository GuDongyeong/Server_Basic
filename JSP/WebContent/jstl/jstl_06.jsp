<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{
	text-align: center; /* 가운데 정렬 */
}

div.result{ }
/* 둘이 같음 위에께 더 좋음 */
div[id^=res]{ 
	border: 1px solid #ccc;
	width : 100px;
	display: inline-block;
	margin: 0 5px;
	padding: 5px 0;
}

div[id^=res]:hover{ 
	background: tomato;
}

#gugudan{
	min-width: 960px;
}
</style>
</head>
<body>

<h1>c:forEach</h1>
<hr>

<%-- step 속성을 적지 않으면 기본값 1 --%>
<c:forEach var="i" begin="1" end="10">
	<h3>${i }</h3>
</c:forEach>

<hr>
<%-- 1~100 까지의 합 구하기 --%>
<%--int total = 0;  --%>
<c:set var="total" value="0" />

<%--for(int i=1;i<=100;i++){  --%>
<c:forEach var="i" begin="1" end="100" step="1">
	
	<%--total = total + i; --%>
	<c:set var="total" value="${total + i }" />

</c:forEach>

<h3>1~100의 합 : ${total }</h3>

<hr>
<h3>구구단</h3>

<%-- 2~9 단 --%>
<%-- <c:forEach var="i" begin="2" end="9" step="1"> --%>
<%-- 	<h3>${i } 단</h3> --%>
<%-- 	<c:forEach var="j" begin="1" end="9" step="1"> --%>
<%-- 		<c:out value="${i } * ${j } = ${i*j }" /><br> --%>
<%-- 	</c:forEach>	 --%>
<%-- </c:forEach> --%>

<div id="gugudan">
<c:forEach var="i" begin="1" end="9" step="1">

	<div>
	<c:forEach var="j" begin="2" end="9" step="1">
	
		<div class="result" id="res${j }${i }">
		<c:out value="${j } * ${i } = ${i*j }" />
		</div>
	
	</c:forEach>	
	</div>
	
</c:forEach>
</div>

<hr>

<h3>c:forEach를 Iterator로 활용하기</h3>

<% Map<Integer, String> map = new HashMap<>(); %>
<% map.put(1, "Apple"); %>
<% map.put(2, "Banana"); %>
<% map.put(3, "Cherry"); %>

<c:forEach var="iter" items="<%=map %>">
	${iter }<br>
	${iter.key } : ${iter.value }<br>
	--------------<br>
</c:forEach>

<hr>

<table border=1>
<tr>
	<th>키</th>
	<th>값</th>
</tr>

<c:forEach var="iter" items="<%=map %>">
<tr>
	<td>${iter.key }</td>
	<td>${iter.value }</td>
</tr>
</c:forEach>
</table>

<hr>

<%
	List<String> list = new ArrayList<>();

	list.add("Alice");
	list.add("Bob");
	list.add("Clare");
	list.add("Dave");
	list.add("Edward");

%>

<c:forEach var="iter" items="<%=list %>" begin="0" end="4" step="1" varStatus="stat">

	<c:if test="${stat.first }">
		<span style="color: red; font-size:8px;">첫 번째 반복입니다</span><br>
	</c:if>


	iter : ${iter }<br>
	반복 중 현재 인덱스 : ${stat.index }<br>
	반복 중 실행 횟수 : ${stat.count }<br>
	
	first : ${stat.first }<br>
	last : ${stat.last }<br>
	step : ${stat.step }<br>
	
	<c:if test="${not stat.last }">
	----------------<br>
	</c:if>
	
	<c:if test="${stat.last }">
		<span style="color: red; font-size:8px;">마지막입니다</span><br>
	</c:if>
	
</c:forEach>


</body>
</html>