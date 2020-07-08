<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input{
	width: 150px;
}

/* 인라인요소.. 너비가 설정되지 않는다 display를 바꾸면 됨*/
label{
	display: inline-block;
	width: 80px;	
}

</style>
</head>
<body>

<h1>신규 사원 등록</h1>
<hr>
<form action="/emp/insert" method="post">

<label for="empno">사원번호</label>
<input type="number" id="empno" name="empno" min="1" max="9999" required="required"/><br><br><!-- 일차적으로 프론트에서 검증 -->

<label for="ename">사원이름</label>
<input type="text" id="ename" name="ename"/><br><br>

<label for="job">직무</label>
<input type="text" id="job" name="job"/><br><br>

<label for="mgr">매니저</label>
<input type="number" id="mgr" name="mgr"  min="1" max="9999" /><br><br>

<label for="hiredate">입사날짜</label>
<input type="date" id="hiredate" name="hiredate"/><br><br>

<label for="sal">급여</label>
<input type="text" id="sal" name="sal"/><br><br>

<label for="comm">상여금</label>
<input type="text" id="comm" name="comm"/><br><br>

<label for="deptno">부서번호</label>
<select id="deptno" name="deptno">
	<option value=""></option>
	<option value="10">ACCOUNT</option>
	<option value="20">RESEARCH</option>
	<option value="30">SALSE</option>
	<option value="40">OPERATIONS</option>
</select><br><br>

<button>추가</button>
</form>

<hr>
<button onclick="history.go(-1)">뒤로 가기</button>

<hr>
<button onclick="location.href='/emp/list'">목록</button>


</body>
</html>