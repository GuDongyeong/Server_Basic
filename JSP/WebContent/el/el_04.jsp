<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>EL 테스트</h1>
<h3>EL의 Parameter 정보</h3>
<hr>

${param } 

<hr>

<h3>표현언어</h3>
id : ${param.id eq "abc" }<br>
pw : ${param.pw }<br>

<hr>
<h3>표현식</h3>
id : <%=request.getParameter("id") %><br>
pw : <%=request.getParameter("pw") %><br>

<hr>
<h3>스크립트릿</h3>
id : <% out.print(request.getParameter("id") ); %><br>
pw : <% out.print(request.getParameter("pw") ); %><br>


<hr>
<h3>paramValues</h3>
${paramValues }<br>
${paramValues.pw }<br>
${paramValues.pw[0] }<br>
${paramValues.pw[1] }<br>

<hr>
${paramValues.hobby[0] }<br>
${paramValues.hobby[1] }<br>
${paramValues.hobby[2] }<br>
</body>
</html>