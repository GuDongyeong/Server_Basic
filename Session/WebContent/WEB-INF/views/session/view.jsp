<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function del(){
	
	location.href = "/session/delete"
}


</script>
</head>
<body>

<h1>세션 확인</h1>
<hr>

test : ${test }<br>

<hr>

<h3>세션 관련 정보 확인하기</h3>

Session ID <%=session.getId() %><br>

CreationTime : <%= new Date(session.getCreationTime()) %><br>
	
LastAccessedTime : <%=new Date(session.getLastAccessedTime()) %><br>
	
MaxInactiveInterval : <%=session.getMaxInactiveInterval() %><br>
	
isNew : <%=session.isNew()  %><br>


<a href="/session/create"><button>세션 생성</button></a>
<button onclick="del();">세션 삭제</button>

</body>
</html>