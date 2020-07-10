<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>에러페이지</h1>
<hr>

<h3>${message }</h3>

<a href="/file/list">파일 목록으로 가기</a>

<%-- <a> 태그의 href 속성에 url이 아닌 javascript 코드를 넣고 싶으면
	접두어로 javascript: 를 적으면 된다 --%>
<a href="javascript:history.go(-1);">이전 페이지로 이동</a>

</body>
</html>










