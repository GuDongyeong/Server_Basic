<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/basicTag/header.jsp"/>

<h1>액션태그 테스트</h1>
<h3>include</h3>
<hr>

<% request.setCharacterEncoding("UTF-8"); %>
<% request.setAttribute("requestDate", "하하하하하"); %>"

<jsp:include page="/actionTag/includePage.jsp">
	<jsp:param value="안녕! HELLO!" name="date" />
</jsp:include>


<jsp:include page="/basicTag/footer.jsp"/>