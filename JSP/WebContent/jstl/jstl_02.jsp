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

<h1>c:out</h1>
<hr>

<c:out value="Hello! JSTL!" /><br>
Hello! JSTL!
<hr>

eldata : <c:out value="${eldata}" /><br> <%-- null값을 가지고 있을 것 만들지도 않았음 --%>
empty : <c:out value="${empty eldata}" /><br>
<hr>


<c:out value="" default="null값 출력함" /><br><%-- ""는 null이 아님 --%>
<c:out value="null" default="null값 출력함" /><br><%-- "null" 문자열 --%>
<c:out value="${null}" default="null값 출력함" /><br><%-- null, el 과 같이 사용해야 함, 데이터타입 등을 다룰 때 --%>
<c:out value="${eldata}" default="null값 출력함" /><br><%-- null, 만들지 않은 변수도 el은 null로 취급해줌 --%>
<c:out value="<%=null %>" default="null값 출력함" /><%-- null --%>
<hr>

<c:out value="<h3>태그 출력</h3>" /><%-- innerTest와 비슷한 동작 --%>
<c:out value="<h3>태그 출력</h3>" escapeXml="false"/><%-- 태그 반영 --%>

<%="<h3>태그 출력</h3>" %><%-- innerHTML과 비슷한 동작, Expression은 태그를 반영하는 것이 기본값 --%>
<%="&lt;h3&gt;태그 출력&lt;/h3&gt;" %>

<%-- 나중에 게시판 제작할 떄 이런식으로 함 --%>
<div id="contents">
<c:out value="${content}" />
</div>

&nbsp;<br><%-- 띄어쓰기 --%>

&laquo;<br><%-- « --%>
&raquo;<br><%-- » --%>

&larr;<br><%-- ← --%>
&rarr;<br><%-- → --%>
<hr>

<% String str = "테스트 문자열"; // Java 영역 변수 %><%-- Java영역이기 떄문에 JSP와 분리되어있음! --%>

str 출력 : <c:out value="${str}" /><br><%-- 출력 X --%>
str 출력 : <c:out value="${pageScope.str}" /><br><%-- 출력 X --%>
str 출력 : <c:out value="<%=str %>" /><br><%-- Java영역이기 때문에 출력됨 --%>

<%-- 스크립트릿은 JSTL의 속성값으로 적용되지 않는다 --%>
<%-- EL과 Expression 을 주로 사용해야 한다 --%>
str 출력 : <c:out value="<% out.print(str); %>" /><br><%-- 예외적인 상황, out.print(str)이 그냥 문자열로 출력됨 --%>

<hr>
<% request.setAttribute("s", str); // request 컨텍스트 영역에 추가 %>
str 출력 : <c:out value="${s}" /><br>
str 출력 : <c:out value="${requestScope.s}" /><br>
<%-- str 출력 : <c:out value="<%=s %>" /><br> --%><%-- Java 코드 문법과 맞지 않아 에러남 --%>

</body>
</html>