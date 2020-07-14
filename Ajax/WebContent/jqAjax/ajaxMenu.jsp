<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.left{
	float: left;
	width: 30%;
	height: 600px;
	background: #ccc;	
}

.right{
	float: right;
	width: 65%;
	height: 600px;
	background: #ffc;
}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("a").click(function(){
		console.log("a 태그 클릭됨");
		
		
		// ** 이벤트 리스너에서 return false;를 실행하면 이벤트의 기본동작(동적 처리) 수행을 막는다
		
		// 클릭이벤트가 발생한 <a>태그의 href 속성을 .load() 함수의 url로 사용
		$(".right").load( $(this).attr("href"));
		
		// <a>태그의 기본 동작 막는다
		return false;
	});	
});
</script>
</head>
<body>

<h1>AJAX 메뉴</h1>
<hr>

<div class="left">
	<a href="/ajax/ajax_01.jsp">AJAX 01</a><br><br>
	<a href="/ajax/ajax_02.jsp">AJAX 02</a><br><br>
	<a href="/ajax/ajax_03.jsp">AJAX 03</a><br><br>
</div>

<div class="right">

</div>

</body>
</html>