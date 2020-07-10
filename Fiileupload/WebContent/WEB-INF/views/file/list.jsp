<%@page import="dto.UploadFile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>첨부 파일 리스트</h1>
<h3>DB에서 꺼내오기</h3>
<hr>

<a href="/commons/fileupload"><button>Commons</button></a>
<a href="/cos/fileupload"><button>Cos</button></a>

<table border=1>
<tr>
	<th>파일 번호</th>
	<th>원본 이름</th>
	<th>저장된 이름</th>
</tr>

<c:forEach items="${list }" var="i">
<tr>
	<td>${i.fileno }</td>
	<td>${i.originName }</td>
	<td>${i.storedName }</td>
</tr>
</c:forEach>

</table>




</body>
</html>